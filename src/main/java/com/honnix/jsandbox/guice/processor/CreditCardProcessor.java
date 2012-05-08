package com.honnix.jsandbox.guice.processor;

import com.google.inject.ImplementedBy;
import com.honnix.jsandbox.guice.model.ChargeResult;
import com.honnix.jsandbox.guice.model.CreditCard;
import com.honnix.jsandbox.guice.exception.UnreachableException;

/**
 * @author honnix
 */
@ImplementedBy(PaypalCreditCardProcessor.class)
public interface CreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException;
}
