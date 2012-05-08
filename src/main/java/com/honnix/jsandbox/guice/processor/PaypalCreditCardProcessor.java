package com.honnix.jsandbox.guice.processor;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.honnix.jsandbox.guice.exception.UnreachableException;
import com.honnix.jsandbox.guice.model.ChargeResult;
import com.honnix.jsandbox.guice.model.CreditCard;

/**
 * @author honnix
 */
public class PaypalCreditCardProcessor implements CreditCardProcessor {
    private String apiKey;

    @Inject
    public PaypalCreditCardProcessor(@Named("Paypal API key") String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException {
        return new ChargeResult() {
            @Override
            public boolean wasSuccessful() {
                return true;
            }

            @Override
            public String getDeclineMessage() {
                return "never";
            }
        };
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
