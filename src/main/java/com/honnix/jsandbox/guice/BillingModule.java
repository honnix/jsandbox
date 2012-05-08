package com.honnix.jsandbox.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.honnix.jsandbox.guice.log.Connection;
import com.honnix.jsandbox.guice.service.BillingService;
import com.honnix.jsandbox.guice.service.RealBillingService;

/**
 * @author honnix
 */
public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Connection.class);
        bind(BillingService.class).to(RealBillingService.class).in(Singleton.class);
        bind(String.class).annotatedWith(Names.named("Paypal API key")).toInstance("my_key");
    }
}
