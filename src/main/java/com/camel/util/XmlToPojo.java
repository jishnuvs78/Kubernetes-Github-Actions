package com.camel.util;

import com.camel.model.Bulkmessage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlToPojo {

    public Bulkmessage getPayload(String payload){

        Bulkmessage bulkmessage=new Bulkmessage();

        try{
            JAXBContext jaxbContext=JAXBContext.newInstance(Bulkmessage.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            bulkmessage=(Bulkmessage) jaxbUnmarshaller.unmarshal(new StringReader(payload));

            System.out.println(bulkmessage);

            return bulkmessage;
        } catch (JAXBException e){
            e.printStackTrace();
        }

        return bulkmessage;

    }

}
