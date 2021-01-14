import java.io.Serializable;

public class Rental implements Serializable
{

	private static final long serialVersionUID = 1L;

	private final IRentable rentable;
	private final int daysRented;
	private double price;

	public Rental(IRentable rentable, int daysRented, Customer customer, int usedPoints){
		this.rentable = rentable;
		this.daysRented = daysRented;
		price = rentable.getPrice(daysRented, customer, usedPoints);
	}

	public Rental(IRentable rentable, int daysRented){
		this.rentable = rentable;
		this.daysRented = daysRented;
	}

	public int getDaysRented(){
		return daysRented;
	}

	public void calculatePrice(Customer customer, int usedPoints){
		price = rentable.getPrice(daysRented, customer, usedPoints);
	}
	/**
	 *
	 * @return the price of this rent depending on the movie the number of days rented
	 */
	public double getPrice(){
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
	public int getLoyaltyPoints(){
		return rentable.getLoyaltyPoints(daysRented);
	}

	public String getDescription(){
		return String.format("\t%s\t%.1f\n", rentable.getDescription(), getPrice() );
	}

}
