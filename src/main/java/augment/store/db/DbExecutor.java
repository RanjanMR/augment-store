package augment.store.db;

import java.sql.SQLException;

public interface DbExecutor{

    public DbResultObject executeQuery(String query)throws SQLException;

    public void beginTransaction()throws SQLException;

    public DbResultObject executeTransactionQuery(String query)throws SQLException;

    public void commitTransaction()throws SQLException;

    public void rollbackTransaction()throws SQLException;
}

