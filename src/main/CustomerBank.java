import java.io.IOException;

public abstract class CustomerBank extends DataBase<Customer, String>{

    public CustomerBank(String ID) {
        super(ID);
    }
}
