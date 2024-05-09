package com.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Folder2FolderRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        InputToOutput();

    }

    public void InputToOutput() {

        from("file:input_box?noop=true")
                .to("file:output_box");

    }

}
