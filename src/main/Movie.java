import java.io.Serializable;

public class Movie implements Serializable
{

	private final String title;
	private final MovieType movieType;
	
	public Movie (String title, MovieType movieType) {
		this.title = title;
		this.movieType = movieType;
	}
	
	public MovieType getMovieType(){
		return movieType;
	}

	public String getTitle(){
		return title;
	}
	
}