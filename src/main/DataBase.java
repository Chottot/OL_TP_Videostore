import java.io.*;
import java.util.ArrayList;

public abstract class DataBase <DataType , DataIdentifierType>{

    protected String ID;

    public DataBase(){
        ID ="default";
    }

    public DataBase(String ID){
        this.ID = ID;
    }

    abstract DataType getData(DataIdentifierType dataID);
    abstract void addData(DataType movie);
    abstract void removeData(DataIdentifierType name);

    public abstract ArrayList<DataType> getDataArray();

    public abstract void save();

    public abstract void Load() throws IOException;

}
