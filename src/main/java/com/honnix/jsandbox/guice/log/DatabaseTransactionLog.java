package com.honnix.jsandbox.guice.log;

import com.honnix.jsandbox.guice.model.ChargeResult;
import com.honnix.jsandbox.guice.exception.UnreachableException;

/**
 * @author honnix
 */
public class DatabaseTransactionLog implements TransactionLog {
    @Override
    public void logChargeResult(ChargeResult result) {

    }

    @Override
    public void logConnectException(UnreachableException e) {

    }
}
