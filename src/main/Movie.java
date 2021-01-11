import java.io.Serializable;

public class Movie implements IRentable, Serializable
{
	private static final long serialVersionUID = 1L;

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

	/**
	 * @return the base price of the movie depending of his type
	 */
	private float getMovieTypeBasePrice(){
		switch (movieType){
			case REGULAR: return 2.0f;
			case CHILDREN: return 1.5f;
			case NEW_RELEASE: return 3.0f;
		}
		return 0;
	}

	/**
	 * @return the number of maximun days we can rent the movie depending of his type
	 *
	 * if we rent the movie longer then that we pays more
	 *
	 * if the movie has no limit on the day rented return -1
	 */
	private int getMovieTypeMaxDaysRentable(){
		switch (movieType){
			case REGULAR: return 2;
			case CHILDREN: return 3;
			case NEW_RELEASE: return -1;
		}
		return 0;
	}

	@Override
	public String getDescription() {
		return getTitle();
	}

	/**
	 *
	 * @return the price of this rent depending on the movie the number of days rented
	 */
	@Override
	public float getPrice(int daysRented, int loyaltyPoint) {
		float price = getMovieTypeBasePrice();

		int maxDaysRentable = getMovieTypeMaxDaysRentable();

		if(movieType == MovieType.NEW_RELEASE){
			price *= daysRented;
		}else if(daysRented> maxDaysRentable ){
			price += (daysRented - maxDaysRentable) *1.5f;
		}
		return price;
	}

	/**
	 *
	 * @return the number of loyalty points earned with this rent
	 *
	 * we gain 1 loyalty points per rent
	 * and 1 more if we rent e new released movie more than one day
	 *
	 */
	@Override
	public int getLoyaltyPoints(int daysRented) {
		int loyaltyPoints = 1;
		if(movieType == MovieType.NEW_RELEASE &&daysRented > 1) {
			loyaltyPoints++;
		}
		return loyaltyPoints;
	}
}