package com.honnix.jsandbox.guice.service;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.honnix.jsandbox.guice.annotation.Paypal;
import com.honnix.jsandbox.guice.log.TransactionLog;
import com.honnix.jsandbox.guice.processor.CreditCardProcessor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Test class for {@link RealBillingService}.
 *
 * @author honnix
 */
public class RealBillingServiceTest {
    private BillingService service;

    public RealBillingServiceTest() {
        super();
    }

    @Before
    public void before() {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(TransactionLog.class).to(mock(TransactionLog.class).getClass());
                bind(CreditCardProcessor.class).annotatedWith(Paypal.class).to(mock(CreditCardProcessor
                        .class).getClass());
            }
        });
        service = injector.getInstance(RealBillingService.class);
    }

    @After
    public void after() {
    }

    @Test
    public void testChargeOrder() {
        System.out.println(service.getClass());
    }
}
