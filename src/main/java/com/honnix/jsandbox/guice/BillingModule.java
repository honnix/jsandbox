package com.honnix.jsandbox.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.honnix.jsandbox.guice.annotation.Paypal;
import com.honnix.jsandbox.guice.log.Connection;
import com.honnix.jsandbox.guice.log.DatabaseTransactionLogProvider;
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
        bind(TransactionLog.class).toProvider(DatabaseTransactionLogProvider.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
        bind(BillingService.class).to(RealBillingService.class);
        bind(String.class).annotatedWith(Names.named("Paypal API key")).toInstance("my_key");
    }

    @Provides
    @Paypal
    private CreditCardProcessor providePaypalCreditCardProcessor(
            @Named("Paypal API key") String apiKey) {
        PaypalCreditCardProcessor processor = new PaypalCreditCardProcessor();
        processor.setApiKey(apiKey);
        return processor;
    }
}
