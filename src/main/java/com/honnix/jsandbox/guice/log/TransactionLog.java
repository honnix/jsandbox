package com.honnix.jsandbox.guice.log;

import com.honnix.jsandbox.guice.model.ChargeResult;
import com.honnix.jsandbox.guice.exception.UnreachableException;

/**
 * @author honnix
 */
public interface TransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(UnreachableException e);
}
