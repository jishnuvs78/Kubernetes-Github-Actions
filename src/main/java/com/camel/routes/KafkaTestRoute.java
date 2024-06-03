package com.camel.routes;

import com.camel.processors.BulkMessageProcessor;
import com.camel.processors.InsertProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestRoute extends RouteBuilder {

    @Autowired
    private BulkMessageProcessor bulkMessageProcessor;

    @Autowired
    private InsertProcessor insertProcessor;

    @Override
    public void configure() throws Exception {

        debulkingRoute();

    }

    public void debulkingRoute(){
        from("activemq:queue:source")
                .process(bulkMessageProcessor);
//                .process(insertProcessor);

    }

}
