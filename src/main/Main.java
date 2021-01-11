import java.io.IOException;

public class Main {

    public static void main(String[] args){
       LocalMovieBank bank = new LocalMovieBank("test1");
       /*
        bank.addMovie( new Movie("regular1", MovieType.REGULAR));
        bank.save();*/

        try {
            bank.Load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bank.movies.get(0).getTitle());


    }
}
