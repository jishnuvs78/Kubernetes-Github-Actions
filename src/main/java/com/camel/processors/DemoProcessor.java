package com.camel.processors;

import com.camel.model.Demo;
import com.camel.service.DemoService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoProcessor implements Processor {

    @Autowired
    private DemoService demoService;

    @Override
    public void process(Exchange exchange) throws Exception {

        try{
            Demo user= new Demo();
            user.setDept("Biology");
            user.setName("Rishav");

            Demo savedUser=demoService.save(user);
            System.out.println(savedUser);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
