package com.honnix.jsandbox.guice.log;

import com.honnix.jsandbox.guice.exception.UnreachableException;
import com.honnix.jsandbox.guice.model.ChargeResult;

/**
 * @author honnix
 */
public class DatabaseTransactionLog implements TransactionLog {
    public DatabaseTransactionLog() {

    }


    public DatabaseTransactionLog(Connection connection) {

    }

    @Override
    public void logChargeResult(ChargeResult result) {

    }

    @Override
    public void logConnectException(UnreachableException e) {

    }

    public void setConnection(Connection connection) {

    }
}
