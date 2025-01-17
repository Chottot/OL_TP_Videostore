import java.io.IOException;

public class Main {

    public static void main(String[] args){

       // testVideoStore();
        testVideoStoreLoad();

    }

    static void testVideoStoreLoad(){
        try {
            VideoStore videoStore = VideoStore.load("videoStore1");

            System.out.println(videoStore.getCustomer("c1").getName());
            System.out.println(videoStore.getMovie("m1").getTitle());

            System.out.println(videoStore.getCustomer("c1").statement());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void testVideoStore(){
        VideoStore videoStore = new VideoStore("videoStore1");
        Movie m1 = new Movie("m1", MovieType.REGULAR);
        Customer customer = new Customer("c1");
        customer.createAndAddRental(m1, 5, 0);

        videoStore.addMovie(m1);
        videoStore.addCustomer(customer);

        videoStore.save();

    }

    static void testLocalCustomerBank(){
        LocalCustomerBank bank = new LocalCustomerBank("customerBank1");
        Customer customer = new Customer("test");
        bank.addData( customer);
        bank.save();

        try {
            bank.load();
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
            bank.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bank.movies.get(0).getTitle());
    }
}
