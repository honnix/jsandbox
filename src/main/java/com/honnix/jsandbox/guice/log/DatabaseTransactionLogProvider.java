package com.honnix.jsandbox.guice.log;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author honnix
 */
public class DatabaseTransactionLogProvider implements Provider<TransactionLog> {
    private final Connection connection;

    @Inject
    public DatabaseTransactionLogProvider(Connection connection) {
        this.connection = connection;
    }

    public TransactionLog get() {
        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
        transactionLog.setConnection(connection);
        return transactionLog;
    }
}
