package com.honnix.jsandbox.guice.processor;

import com.honnix.jsandbox.guice.model.ChargeResult;
import com.honnix.jsandbox.guice.model.CreditCard;
import com.honnix.jsandbox.guice.exception.UnreachableException;

/**
 * @author honnix
 */
public class PaypalCreditCardProcessor implements CreditCardProcessor {
    private String apiKey;

    @Override
    public ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException {
        return null;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
