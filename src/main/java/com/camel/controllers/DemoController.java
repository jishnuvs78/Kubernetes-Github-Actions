package com.camel.controllers;

import com.camel.model.Demo;
import com.camel.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addUser")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping
    public Demo createUser(@RequestBody Demo user){
        return demoService.save(user);
    }

}
