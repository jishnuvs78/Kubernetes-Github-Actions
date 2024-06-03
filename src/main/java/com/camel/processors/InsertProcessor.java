package com.camel.processors;

import com.camel.model.Payload;
import com.camel.service.PayloadService;
import com.camel.util.GenerateUUId;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertProcessor implements Processor {

    @Autowired
    private PayloadService payloadService;

    @Override
    public void process(Exchange exchange) throws Exception {

        try {

            String uuid = new GenerateUUId().getUUId();

            Payload payload=new Payload();

            payload.setHermes_id(uuid);
            payload.setPayload(exchange.getIn().getBody(String.class));
            exchange.setProperty("payload",payload.getPayload());
            exchange.setProperty("hermesId",uuid);
            payload.setStg_id(1);

            Payload newPayload=payloadService.save(payload);

            System.out.println(newPayload);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
