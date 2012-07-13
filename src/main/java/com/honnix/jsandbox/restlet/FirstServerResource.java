package com.honnix.jsandbox.restlet;

import java.util.Map.Entry;

import org.restlet.data.Parameter;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class FirstServerResource extends ServerResource {
    @Get
    public String toString() {
        for (Entry<String, Object> entry : getRequestAttributes().entrySet()) {
            System.out.println(entry.getValue());
        }

        for (Parameter parameter : getRequest().getResourceRef().getQueryAsForm()) {
            System.out.println("parameter " + parameter.getName());
            System.out.println("value " + parameter.getValue());
        }

        return "Hello World!";
    }
}
