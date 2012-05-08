package com.honnix.jsandbox.guice.service;

import com.google.inject.Inject;
import com.honnix.jsandbox.guice.exception.UnreachableException;
import com.honnix.jsandbox.guice.log.TransactionLog;
import com.honnix.jsandbox.guice.model.ChargeResult;
import com.honnix.jsandbox.guice.model.CreditCard;
import com.honnix.jsandbox.guice.model.PizzaOrder;
import com.honnix.jsandbox.guice.model.Receipt;
import com.honnix.jsandbox.guice.processor.CreditCardProcessor;

/**
 * @author honnix
 */
public class RealBillingService implements BillingService {
    private final CreditCardProcessor processor;

    private final TransactionLog transactionLog;

    @Inject
    public RealBillingService(CreditCardProcessor processor, TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            return result.wasSuccessful()
                    ? Receipt.forSuccessfulCharge(order.getAmount())
                    : Receipt.forDeclinedCharge(result.getDeclineMessage());
        } catch (UnreachableException e) {
            transactionLog.logConnectException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }
}
