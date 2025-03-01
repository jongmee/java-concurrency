package coupon.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class DataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        boolean isTransactionReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        if (isTransactionReadOnly) {
            return DataSourceKey.READER;
        }
        return DataSourceKey.WRITER;
    }
}
