package com.honnix.jsandbox.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.honnix.jsandbox.guice.service.BillingService;

/**
 * @author honnix
 */
public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        BillingService billingService = injector.getInstance(BillingService.class);
        billingService.chargeOrder(null, null);
    }
}
