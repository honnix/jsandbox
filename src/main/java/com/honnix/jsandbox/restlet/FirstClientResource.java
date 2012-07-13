package com.honnix.jsandbox.restlet;

import java.io.IOException;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class FirstClientResource {
    public static void main(String[] args) throws ResourceException, IOException {
        ClientResource clientResource = new ClientResource("http://localhost:8182/app/hello?test=1");
        clientResource.getConverterService().setEnabled(true);

        ChallengeResponse authentication = new ChallengeResponse(ChallengeScheme.HTTP_BASIC, "scott", "tiger");
        clientResource.setChallengeResponse(authentication);

        FirstResource firstResource = clientResource.wrap(FirstResource.class);
        System.out.println(firstResource.hello());

        clientResource.get(MediaType.APPLICATION_JSON).write(System.out);
    }
}
