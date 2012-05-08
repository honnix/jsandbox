package com.honnix.jsandbox.guice.processor;

import com.honnix.jsandbox.guice.model.ChargeResult;
import com.honnix.jsandbox.guice.model.CreditCard;
import com.honnix.jsandbox.guice.exception.UnreachableException;

/**
 * @author honnix
 */
public interface CreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException;
}
