import java.io.*;
import java.util.ArrayList;

public class LocalCustomerBank extends CustomerBank{

    private ArrayList<Customer> customers;

    public LocalCustomerBank(String ID) {
        super(ID);
        customers = new ArrayList<>();
    }

    @Override
    Customer getData(String name) {
        for (Customer customer : customers) {
            if(customer.getName().equals(name)){
                return customer;
            }
        }
        return null;
    }

    @Override
    void addData(Customer customer) {
        customers.add(customer);
    }

    @Override
    void removeData(String name) {
        customers.removeIf(customer -> customer.getName().equals(name));
    }

    @Override
    public ArrayList<Customer> getDataArray() {
        return customers;
    }

    @Override
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream(ID);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void Load() throws IOException {
        FileInputStream fin = new FileInputStream(ID);
        ObjectInputStream ois = new ObjectInputStream(fin);

        try {
            customers = (ArrayList<Customer>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }
}
