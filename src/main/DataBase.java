import java.io.*;

public abstract class DataBase <DataType , DataIdentifierType>{

    protected String ID;

    public DataBase(String ID){
        this.ID = ID;
    }

    abstract DataType getData(DataIdentifierType dataID);
    abstract void addData(DataType movie);
    abstract void removeData(DataIdentifierType name);

    public abstract void save();

    public abstract void Load() throws IOException;

}
