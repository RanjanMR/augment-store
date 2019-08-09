package augment.store.db.postgres;
import augment.store.db.DbResultObject;

import  java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class PostgresTransactionHandler {
    Connection connection = null;

    public void beginTransaction() throws SQLException{
        if(connection == null) {
            connection = PostgresConnectionPool.getConnection();
            connection.setAutoCommit(false);
        }
        else {
            // throw "connection failed";
        }
    }

    public DbResultObject executeQuery(String query) throws SQLException {
        Statement sql= connection.createStatement();
        boolean state =sql.execute(query);
        DbResultObject dbResult;
        if(state) {
            dbResult = new PostgresResultObjectImpl(sql.getResultSet());
        }
        else {
            dbResult = new PostgresResultObjectImpl(null);
        }
        return dbResult;

    }

    public void commitTransaction() throws SQLException {
        connection.commit();
        connection.close();
    }

    public void rollbackTransaction() throws SQLException{
        connection.rollback();
        connection.close();
    }

}
