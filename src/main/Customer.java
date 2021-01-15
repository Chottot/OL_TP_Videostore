import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;

	/**
	 * the customer name
	 */
	private final String name;
	/**
	 * the historic of the rent
	 */
	private ArrayList<Rental> rentals = new ArrayList<>();

	/**
	 * the number of loyaltyPoints the customer have
	 */
	private int loyaltyPoints;

	public Customer(String name){
		this.name = name;
		loyaltyPoints = 0;
	}

	/**
	 * <p>
	 * see {@link Rental#Rental(IRentable, int, Customer, int)} for the parameter description <br>
	 *  create a rental and add to the historic of the customer
	 * </p>
	 */
	public void createAndAddRental(IRentable rentable, int daysRented, int usedPoints){
		AddRental( new Rental(rentable, daysRented, this, usedPoints) );
	}

	/**
	 *
	 * @param rental the rental to add to the historic
	 *              <p><br
	 *               add the number of loyaltyPoints earned by this rent <br>
	 *               use {@link Customer#addLoyaltyPoints(int)} and {@link Rental#getLoyaltyPoints()}
	 *              </p>
	 */
	private void AddRental(Rental rental){
		addLoyaltyPoints( rental.getLoyaltyPoints());
		rentals.add(rental);
	}
	
	public String getName(){
		return name;
	}

	/**
	 * @return the statement in a formatted String
	 */
	public String statement(){
		double totalCost = 0; 		// total cost

		StringBuilder stringBuilder = new StringBuilder( String.format( "Rental Record for %s\n", getName()) );

		for (Rental rent: rentals) {
			stringBuilder.append( rent.getDescription());
			totalCost +=  rent.getPrice();
		}

		stringBuilder.append( String.format( "You owed %.1f\nYou earned %d frequent renter points\n", totalCost, loyaltyPoints));

		return stringBuilder.toString();
	}

	public int getLoyaltyPoints(){
		return loyaltyPoints;
	}

	/**
	 *
	 * @param loyaltyPoints the new number of point of the customer
	 *                      can't be < 0
	 *
	 */
	public void setLoyaltyPoints(int loyaltyPoints){
		this.loyaltyPoints = Math.max(loyaltyPoints, 0);
	}

	/**
	 *
	 * @param loyaltyPoints the amount of point to add or subtract if it's <0
	 *                      the customer loyaltyPoints can't be < 0
	 */
	public void addLoyaltyPoints(int loyaltyPoints){
		setLoyaltyPoints(this.loyaltyPoints + loyaltyPoints);
	}


	/**
	 * delete all the historic and set the loyaltyPoints to 0
	 */
	public void resetAllRent(){
		rentals = new ArrayList<>();
		loyaltyPoints = 0;
	}

	public ArrayList<Rental> getRentals() {
		return rentals;
	}
}