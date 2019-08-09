package augment.store.db.postgres;

import augment.store.db.DbExecutor;
import augment.store.db.DbResultObject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class PostgresExecutorImpl implements DbExecutor {
    PostgresTransactionHandler transaction = new PostgresTransactionHandler();

    public DbResultObject executeQuery(String query) throws SQLException {

        Connection postgres = PostgresConnectionPool.getConnection();
        Statement stmt = postgres.createStatement();
        boolean status = stmt.execute(query);
        DbResultObject dbResult;
        if(status) {
            dbResult = new PostgresResultObjectImpl(stmt.getResultSet());
        }
        else {
            dbResult = new PostgresResultObjectImpl(null);
        }
        postgres.close();
        return dbResult;
    }

    public void beginTransaction() throws SQLException{

        transaction.beginTransaction();

    }

    public DbResultObject executeTransactionQuery(String query) throws SQLException{

        return transaction.executeQuery(query);
    }

    public void commitTransaction() throws SQLException{

        transaction.commitTransaction();

    }

    public void rollbackTransaction() throws SQLException{

        transaction.rollbackTransaction();

    }
}
