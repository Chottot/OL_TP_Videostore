import java.io.*;

public class VideoStore implements Serializable {

    private static final long serialVersionUID = 1L;

    String ID;
    public MovieBank movieBank;
    public CustomerBank customerBank;

    public VideoStore() {
    }

    public VideoStore(String ID) {
        this.ID = ID;
        movieBank = new LocalMovieBank(ID+"_movieBank");
        customerBank = new LocalCustomerBank(ID+"_customerBank");
    }

    public void addMovie(Movie movie){
        movieBank.addData(movie);
    }

    public void addCustomer(Customer customer){
        customerBank.addData(customer);
    }

    public Movie createAndAddMovie(String movieTitle, MovieType movieType){
        Movie movie = new Movie(movieTitle, movieType);
        addMovie( movie);
        return movie;
    }

    public Customer createAndAddCustomer(String customerName){
        Customer customer = new Customer(customerName);
        addCustomer( customer);
        return  customer;
    }

    public void save(){
        try {
            FileOutputStream fos = new FileOutputStream(ID);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static VideoStore load(String name) throws IOException {
        FileInputStream fin = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fin);
        VideoStore videoStore = null;
        try {
            videoStore = (VideoStore) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
        return videoStore;
    }

}
