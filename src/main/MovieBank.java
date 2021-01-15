import java.io.Serializable;

/**
 * any class that extends this class
 * should be able to save durably all the movie
 * and to load it back
 */
public abstract class MovieBank extends DataBase<Movie, String> {

    public MovieBank(String ID) {
        super(ID);
    }
}
