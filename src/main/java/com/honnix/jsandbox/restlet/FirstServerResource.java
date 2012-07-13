package com.honnix.jsandbox.restlet;

import java.util.Map.Entry;

import org.restlet.data.Parameter;
import org.restlet.resource.ServerResource;

public class FirstServerResource extends ServerResource implements FirstResource {
    public HelloWorld hello() {
        System.out.println(getRequestAttributes().get("query"));
        for (Entry<String, Object> entry : getRequestAttributes().entrySet()) {
            System.out.println(entry.getValue());
        }

        for (Parameter parameter : getRequest().getResourceRef().getQueryAsForm()) {
            System.out.println(parameter);
        }

        return new HelloWorld();
    }
}
