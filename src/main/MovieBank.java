import java.io.Serializable;

public abstract class MovieBank extends DataBase<Movie, String> implements Serializable {

    public MovieBank(){
        super();
    }

    public MovieBank(String ID) {
        super(ID);
    }
}
