import java.io.*;

public class VideoStore implements Serializable {

    private static final long serialVersionUID = 1L;

    private  String ID;
    private  MovieBank movieBank;
    private  CustomerBank customerBank;

    /**
     * create a default videoStore with the name "VideoStore"
     */
    public VideoStore() {
    }

    /**
     *
     * @param ID the identifier or name of the videoStore
     *
     * create a videoStore with the name ID
     */
    public VideoStore(String ID) {
        this.ID = ID;
        movieBank = new LocalMovieBank(ID+"_movieBank");
        customerBank = new LocalCustomerBank(ID+"_customerBank");
    }

    /**
     *
     * @param customerName the name of the customer to get
     * @return the customer with this name or null if there is no customer with this name in the dataBase
     */
    public Customer getCustomer(String customerName){
        return customerBank.getData(customerName);
    }

    /**
     *
     * @param movieTitle the title of the movie to get
     * @return the movie with this name or null if there is no movie with this name in the dataBase
     */
    public Movie getMovie(String movieTitle){
        return movieBank.getData(movieTitle);
    }

    /**
     * @param movie the movie to add to the dataBase
     */
    public void addMovie(Movie movie){
        movieBank.addData(movie);
    }

    /**
     * @param customer the customer to add to the dataBase
     */
    public void addCustomer(Customer customer){
        customerBank.addData(customer);
    }

    /**
     *
     * @param movieTitle the movie title of the movie to create
     * @param movieType the movie type of the movie to create
     * @return the movie created
     *
     * create a movie and add it to the dataBase
     */
    public Movie createAndAddMovie(String movieTitle, MovieType movieType){
        Movie movie = new Movie(movieTitle, movieType);
        addMovie( movie);
        return movie;
    }

    /**
     *
     * @param customerName the name of the customer to create
     * @return the customer created
     *
     * create a custoimer and add it to the dataBase
     */
    public Customer createAndAddCustomer(String customerName){
        Customer customer = new Customer(customerName);
        addCustomer( customer);
        return  customer;
    }
    /**
     * @param movie the movie to remove of the dataBase
     */
    public void removeMovie(Movie movie){ movieBank.removeData(movie.getTitle()); }

    /**
     * @param customer the customer to remove of the dataBase
     */
    public void removeCustomer(Customer customer){
        customerBank.removeData(customer.getName());
    }

    /**
     * @param movieTitle the movieTitle of the movie to remove of the dataBase
     */
    public void removeMovie(String movieTitle){ movieBank.removeData(movieTitle); }

    /**
     * @param customerName the customerName of customer to remove of the dataBase
     */
    public void removeCustomer(String customerName){
        customerBank.removeData(customerName);
    }

    public void save(){
        try {
            FileOutputStream fos = new FileOutputStream(ID);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            customerBank.save();
            movieBank.save();
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
            videoStore.customerBank.load();
            videoStore.movieBank.load();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
        return videoStore;
    }

}
