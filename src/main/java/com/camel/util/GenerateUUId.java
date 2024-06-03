package com.camel.util;

import java.util.UUID;

public class GenerateUUId {

    public String getUUId(){
        UUID uuid=UUID.randomUUID();

        return uuid.toString();
    }

}
