package com.camel.processors;

import com.camel.model.Bulkmessage;
import com.camel.util.XmlToPojo;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class BulkMessageProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        Bulkmessage payload= new XmlToPojo().getPayload(exchange.getIn().getBody(String.class));
        System.out.println(payload.getPayload1() +"\n"+ payload.getPayload1().getClass());

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true"); // Ensure idempotent producer
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "my-transactional-id");

        Producer<String, String> producer = new KafkaProducer<>(props);

        producer.initTransactions();

        int i=0;

        try{
            producer.beginTransaction();
            System.out.println("Entered Producer");
            // Send multiple records within a transaction
            producer.send(new ProducerRecord<>("source", "payload1", payload.getPayload1()));
            producer.send(new ProducerRecord<>("source", "payload2", payload.getPayload2()));
            producer.send(new ProducerRecord<>("source", "payload3", payload.getPayload3()));

            // Commit the transaction
//            if(i==0){
//                throw new KafkaException("Custom Exception");
//            }

            producer.commitTransaction();
        } catch(ProducerFencedException | OutOfOrderSequenceException | AuthorizationException e) {
            // Fatal errors, cannot continue with this producer
            e.printStackTrace();
            producer.close();
        } catch(KafkaException e){
            e.printStackTrace();
            producer.abortTransaction();
        }

        producer.close();

    }

}
