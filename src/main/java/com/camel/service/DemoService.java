package com.camel.service;

import com.camel.model.Demo;
import com.camel.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public Demo save(Demo demo){
        return demoRepository.save(demo);
    }

}
