package augment.store.db.postgres;
import augment.store.db.DbResultObject;

import java.sql.ResultSet;


public class PostgresResultObjectImpl implements DbResultObject {
    ResultSet resultSet;

    public PostgresResultObjectImpl(ResultSet resultObject) {
        resultSet = resultObject;
    }

    public boolean isNextRow() {
        try {
            if(resultSet == null)
            {
                return false;
            }
            return resultSet.next();
        }
        catch(Exception ex) {
            return false;
        }
    }

    public String getString(String columnLabel) {
        try {
            return resultSet.getString(columnLabel);
        }
        catch(Exception ex) {
            return null;
        }
    }

    public int getInt(String columnLabel) {
        try {
            return resultSet.getInt(columnLabel);
        }
        catch(Exception ex) {
            return Integer.MAX_VALUE;
        }
    }
    public double getDouble(String columnLabel) {
        try {

            return resultSet.getDouble(columnLabel);
        }
        catch(Exception ex) {
            return Double.MAX_VALUE;
        }
    }
    public long getTimestamp(String columnLabel) {
        try {
            return resultSet.getTimestamp(columnLabel).getTime();
        }
        catch(Exception ex) {
            return Long.MIN_VALUE;
        }

    }

}
