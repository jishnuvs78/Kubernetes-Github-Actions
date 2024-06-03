//package com.camel.routes;
//
//import com.camel.processors.DemoProcessor;
//import com.camel.service.DemoService;
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Folder2FolderRoute extends RouteBuilder {
//
//    @Autowired
//    private DemoProcessor demoProcessor;
//
//    @Override
//    public void configure() throws Exception {
//
//        InputToOutput();
//
//    }
//
//    public void InputToOutput() {
//
//        from("file:input_box?noop=true")
//                .process(demoProcessor)
//                .to("file:output_box");
//
//    }
//
//}
