import java.io.Serializable;

public abstract class CustomerBank extends DataBase<Customer, String> implements Serializable {

    private static final long serialVersionUID = 1L;

    public CustomerBank(){
        super();
    }

    public CustomerBank(String ID) {
        super(ID);
    }
}
