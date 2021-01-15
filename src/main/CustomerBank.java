import java.io.Serializable;


/**
 * any class that extends this class
 * should be able to save durably all the customer
 * and to load it back
 */
public abstract class CustomerBank extends DataBase<Customer, String>  {

    public CustomerBank(String ID) {
        super(ID);
    }
}
