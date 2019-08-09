package augment.store.db;

import augment.store.db.postgres.PostgresExecutorImpl;

public class DbExecutorFactory {
    public static DbExecutor getDbExecutor() {
        return new PostgresExecutorImpl();
    }
}
