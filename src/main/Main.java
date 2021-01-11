import java.io.IOException;

public class Main {

    public static void main(String[] args){

        testLocalCustomerBank();

    }

    static void testLocalCustomerBank(){
        LocalCustomerBank bank = new LocalCustomerBank("customerBank1");
        Customer customer = new Customer("test");
        bank.addData( customer);
        bank.save();

        try {
            bank.Load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bank.getData("test"));
    }

    void testLocalMovieBank(){
        LocalMovieBank bank = new LocalMovieBank("movieBank1");

        bank.addData( new Movie("regular1", MovieType.REGULAR));
        bank.save();

        try {
            bank.Load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bank.movies.get(0).getTitle());
    }
}
