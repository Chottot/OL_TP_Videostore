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
	}
	
	public void addRental(Rental rental){
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

	public void resetAllRent(){
		rentals = new ArrayList<>();
	}

}