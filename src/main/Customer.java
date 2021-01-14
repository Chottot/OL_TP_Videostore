import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;

	private final String name;
	private ArrayList<Rental> rentals = new ArrayList<>();
	private int loyaltyPoints;

	public Customer(String name){
		this.name = name;
		loyaltyPoints = 0;
	}

	public void addRental(IRentable rentable, int daysRented, int usedPoints){
		addRental( new Rental(rentable, daysRented, this, usedPoints) );
	}
	
	private void addRental(Rental rental){
		addLoyaltyPoints( rental.getLoyaltyPoints());
		rentals.add(rental);
	}
	
	public String getName(){
		return name;
	}
	
	public String statement(){
		double totalCost = 0; 		// total cost
		int	loyaltyPoints = 0;		// loyalty points

		StringBuilder stringBuilder = new StringBuilder( String.format( "Rental Record for %s\n", getName()) );

		for (Rental rent: rentals) {
			double rentalCost = rent.getPrice();		// cost of the rent

			loyaltyPoints += rent.getLoyaltyPoints();

			stringBuilder.append( rent.getDescription());

			totalCost += rentalCost;
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
	 * @param loyaltyPoints the amount of point to add or substract id it's <0
	 *                      the customer loyaltyPoints can't be < 0
	 */
	public void addLoyaltyPoints(int loyaltyPoints){
		setLoyaltyPoints(this.loyaltyPoints + loyaltyPoints);
	}

	public void resetAllRent(){
		rentals = new ArrayList<>();
	}

	public ArrayList<Rental> getRentals() {
		return rentals;
	}
}