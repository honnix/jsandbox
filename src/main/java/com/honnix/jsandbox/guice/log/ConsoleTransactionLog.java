package com.honnix.jsandbox.guice.log;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.honnix.jsandbox.guice.exception.UnreachableException;
import com.honnix.jsandbox.guice.model.ChargeResult;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author honnix
 */
@Singleton
public class ConsoleTransactionLog implements TransactionLog {
    private final Logger logger;

    @Inject
    public ConsoleTransactionLog(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void logChargeResult(ChargeResult result) {
        logger.log(Level.INFO, result.getDeclineMessage());
    }

    @Override
    public void logConnectException(UnreachableException e) {
        logger.log(Level.INFO, e.getMessage());
    }
}
