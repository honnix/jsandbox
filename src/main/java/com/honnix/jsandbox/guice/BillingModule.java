package com.honnix.jsandbox.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.honnix.jsandbox.guice.annotation.Paypal;
import com.honnix.jsandbox.guice.log.Connection;
import com.honnix.jsandbox.guice.log.ConsoleTransactionLog;
import com.honnix.jsandbox.guice.log.DatabaseTransactionLog;
import com.honnix.jsandbox.guice.log.TransactionLog;
import com.honnix.jsandbox.guice.processor.CreditCardProcessor;
import com.honnix.jsandbox.guice.processor.PaypalCreditCardProcessor;
import com.honnix.jsandbox.guice.service.BillingService;
import com.honnix.jsandbox.guice.service.RealBillingService;

import javax.inject.Named;

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
