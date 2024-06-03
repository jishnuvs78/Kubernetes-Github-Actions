package com.camel.processors;

import com.camel.service.PayloadService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StgIdProcessor implements Processor {

    @Autowired
    private PayloadService payloadService;

    @Override
    public void process(Exchange exchange) throws Exception {

        try{
            String Hermes_id=exchange.getProperty("hermesId",String.class);


        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
