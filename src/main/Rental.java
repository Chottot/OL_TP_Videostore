import java.io.Serializable;

public class Rental implements Serializable
{

	private static final long serialVersionUID = 1L;

	private final IRentable rentable;
	private final int daysRented;

	public Rental(IRentable rentable, int daysRented){
		this.rentable = rentable;
		this.daysRented = daysRented;
	}

	public int getDaysRented(){
		return daysRented;
	}


	/**
	 *
	 * @return the price of this rent depending on the movie the number of days rented
	 */
	public float getPrice(){
		return rentable.getPrice(daysRented, 0);
	}

	/**
	 *
	 * @return the number of loyalty points earned with this rent
	 *
	 * we gain 1 loyalty points per rent
	 * and 1 more if we rent e new released movie more than one day
	 *
	 */
	public int getLoyaltyPoints(){
		return rentable.getLoyaltyPoints(daysRented);
	}

	public String getDescription(){
		return String.format("\t%s\t%.1f\n", rentable.getDescription(), getPrice() );
	}

}
