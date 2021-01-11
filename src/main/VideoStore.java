import java.io.*;
import java.util.ArrayList;

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
