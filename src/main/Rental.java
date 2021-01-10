public class Rental
{
	private final Movie movie;
	private final int daysRented;

	public Rental(Movie movie, int daysRented){
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented(){
		return daysRented;
	}

	/**
	 *
	 * @param movieType
	 * @return the base prive of the movie depending of his type
	 */
	private float getMovieTypeBasePrice(MovieType movieType){
		switch (movieType){
			case REGULAR: return 2.0f;
			case CHILDREN: return 1.5f;
			case NEW_RELEASE: return 3.0f;
		}
		return 0;
	}

	/**
	 * @param movieType
	 * @return the number of maximun days we can rent the movie depending of his type
	 *
	 * if we rent the movie longer then that we pays more
	 *
	 * if the movie has no limit on the day rented return -1
	 */
	private int getMovieTypeMaxDaysRentable(MovieType movieType){
		switch (movieType){
			case REGULAR: return 2;
			case CHILDREN: return 3;
			case NEW_RELEASE: return -1;
		}
		return 0;
	}

	/**
	 *
	 * @return the price of this rent depending on the movie the number of days rented
	 */
	public float getPrice(){
		float price = getMovieTypeBasePrice(movie.getMovieType());

		int maxDaysRentable = getMovieTypeMaxDaysRentable(movie.getMovieType());

		if(daysRented> maxDaysRentable && maxDaysRentable > 0){
			price += (daysRented - maxDaysRentable) *1.5f;
		}
		return price;
	}

	public Movie getMovie(){
		return movie;
	}

}
