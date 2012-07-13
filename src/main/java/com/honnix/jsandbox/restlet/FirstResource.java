package com.honnix.jsandbox.restlet;

import org.restlet.resource.Get;

public interface FirstResource {
    @Get
    HelloWorld hello();
}
