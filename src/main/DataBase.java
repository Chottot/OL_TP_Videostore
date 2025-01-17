import java.io.*;
import java.util.ArrayList;

/**
 *
 * @param <DataType>            the type of data that os stored
 * @param <DataIdentifierType>  the type of the identifier of the data stored
 */
public abstract class DataBase <DataType , DataIdentifierType> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * the ID or name of the data Base
     */
    protected String ID;


    public DataBase(){
    }

    /**
     * @param ID the of data Base
     */
    public DataBase(String ID){
        this.ID = ID;
    }

    /**
     *
     * @param dataID the data identifier
     * @return the data witch match the data identifier or null id no match
     */
    abstract DataType getData(DataIdentifierType dataID);

    /**
     *
     * @param data the data to add
     */
    abstract void addData(DataType data);

    /**
     *
     * @param dataID the identifier of the data to remove
     */
    abstract void removeData(DataIdentifierType dataID);

    public abstract ArrayList<DataType> getDataArray();

    public abstract void save();

    public abstract void load() throws IOException;

}
