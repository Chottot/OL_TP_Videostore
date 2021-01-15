import java.io.*;
import java.util.ArrayList;

public class LocalMovieBank extends MovieBank {

    ArrayList<Movie> movies;

    public LocalMovieBank(String ID) {
        super(ID);
        movies = new ArrayList<>();
    }

    @Override
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream(ID);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(movies);
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
            movies = (ArrayList<Movie>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }

    @Override
    Movie getData(String name) {
        for (Movie movie : movies) {
            if(movie.getTitle().equals(name)){
                return movie;
            }
        }
        return null;
    }

    @Override
    void addData(Movie movie) {
        movies.add(movie);
    }

    @Override
    void removeData(String name) {
        movies.removeIf(movie -> movie.getTitle().equals(name));
    }

    @Override
    public ArrayList<Movie> getDataArray() {
        return movies;
    }

}
