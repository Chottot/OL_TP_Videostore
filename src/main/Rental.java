import java.io.Serializable;

public class Rental implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**
	 *  the thing that has been rented
	 */
	private final IRentable rentable;

	/**
	 * the number of days {@link Rental#rentable } has been rented
	 */
	private final int daysRented;

	/**
	 * the price of rent 
	 * calculated by {@link Rental#calculatePrice(Customer, int)}
	 */
	private double price;

	/**
	 *
	 * @param rentable   {@link Rental#rentable }
	 * @param daysRented {@link Rental#daysRented }
	 * @param customer   the customer that is renting
	 * @param usedPoints the number of point the customer want to use
	 *
	 * <p>
	 *  create a new Rental and calculate the price with {@link Rental#calculatePrice(Customer, int)}
	 * </p>
	 */
	public Rental(IRentable rentable, int daysRented, Customer customer, int usedPoints){
		this.rentable = rentable;
		this.daysRented = daysRented;
		calculatePrice( customer, usedPoints);
	}

	public int getDaysRented(){
		return daysRented;
	}

	/**
	 *
	 * @param customer the customer that is renting
	 * @param usedPoints the number of loyaltyPoint the customer want to use
	 *
	 * <p> use {@link IRentable#getPrice(int, Customer, int)} to calculate the price  then store it in {@link Rental#price} </p>
	 */
	public void calculatePrice(Customer customer, int usedPoints){
		price = rentable.getPrice(daysRented, customer, usedPoints);
	}

	/**
	 * @return the price of this rent depending on the movie the number of days rented
	 */
	public double getPrice(){
		return price;
	}

	/**
	 *
	 * @return the number of loyalty points earned with this rent
	 *<p>
	 * we gain 1 loyalty points per rent
	 * and 1 more if we rent e new released movie more than one day
	 *</p>
	 */
	public int getLoyaltyPoints(){
		return rentable.getLoyaltyPoints(daysRented);
	}

	/**
	 *
	 * @return a formated String that describe the Rental
	 */
	public String getDescription(){
		return String.format("\t%s\t%.1f\n", rentable.getDescription(), getPrice() );
	}

}
