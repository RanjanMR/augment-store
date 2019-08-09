package augment.store.db;

public interface DbResultObject{

    public int getInt(String columnLabel) ;

    public double getDouble(String columnLabel);

    public long getTimestamp(String columnLabel);

    public String getString(String columnLabel);

    public boolean isNextRow();


}
