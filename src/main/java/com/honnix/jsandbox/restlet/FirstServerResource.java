package com.honnix.jsandbox.restlet;

import java.util.Map.Entry;

import org.restlet.data.Parameter;
import org.restlet.resource.ServerResource;

public class FirstServerResource extends ServerResource implements FirstResource {
    public String hello() {
        for (Entry<String, Object> entry : getRequestAttributes().entrySet()) {
            System.out.println(entry.getValue());
        }

        for (Parameter parameter : getRequest().getResourceRef().getQueryAsForm()) {
            System.out.println(parameter);
        }

        return "Hello World!";
    }
}
