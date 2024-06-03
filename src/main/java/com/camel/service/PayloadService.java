package com.camel.service;

import com.camel.model.Payload;
import com.camel.repository.PayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayloadService {

    @Autowired
    private PayloadRepository payloadRepository;

    public Payload save(Payload payload){
        return payloadRepository.save(payload);
    }

}
