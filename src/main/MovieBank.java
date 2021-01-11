import java.io.Serializable;

public abstract class MovieBank extends DataBase<Movie, String> implements Serializable {

    private static final long serialVersionUID = 1L;

    public MovieBank(){
        super();
    }

    public MovieBank(String ID) {
        super(ID);
    }
}
