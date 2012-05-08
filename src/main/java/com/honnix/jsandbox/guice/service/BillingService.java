package com.honnix.jsandbox.guice.service;

import com.honnix.jsandbox.guice.model.CreditCard;
import com.honnix.jsandbox.guice.model.PizzaOrder;
import com.honnix.jsandbox.guice.model.Receipt;

/**
 * @author honnix
 */
public interface BillingService {

    /**
     * Attempts to charge the order to the credit card. Both successful and
     * failed transactions will be recorded.
     *
     * @return a receipt of the transaction. If the charge was successful, the
     *      receipt will be successful. Otherwise, the receipt will contain a
     *      decline note describing why the charge failed.
     */
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
