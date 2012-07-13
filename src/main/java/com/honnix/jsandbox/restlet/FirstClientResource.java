package com.honnix.jsandbox.restlet;

import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class FirstClientResource {
    public static void main(String[] args) throws ResourceException, IOException {
        new ClientResource("http://localhost:8182").get().write(System.out);
    }
}
