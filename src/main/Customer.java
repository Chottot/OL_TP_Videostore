import java.util.ArrayList;

public class Customer 
{

	private final String name;
	private final ArrayList<Rental> rentals = new ArrayList<>();

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
			double rentalCost = 0;		// cost of the rent
			
			// determines the cost of the rent
			switch (rent.getMovie().getMovieType()) {
				case REGULAR:											// regular movie
					rentalCost += 2;										// we pay 2<money> up to 2 days of rent
					if (rent.getDaysRented() > 2) {
						rentalCost += (rent.getDaysRented() - 2) * 1.5; 	// and 1.5<money> per day after 2 day of rent
					}
					break;

				case NEW_RELEASE:										// new released movie
					rentalCost += rent.getDaysRented() * 3;					// 3<money> by day
					break;

				case CHILDREN:										// children movie
					rentalCost += 1.5;										// we pay 1.5<money> up to 3 days of rent
					if (rent.getDaysRented() > 3) {
						rentalCost += (rent.getDaysRented() - 3) * 1.5;		// and 1.5<money> per day after 3 day of rent
					}
					break;
			}
			
			loyaltyPoints++; // we get 1 loyalty point per rents

			// we get 1 loyalty point if we rent a new released movie more than one day
			if(rent.getMovie().getMovieType() == MovieType.NEW_RELEASE && rent.getDaysRented() > 1) {
				loyaltyPoints++;
			}
				
			stringBuilder.append( String.format( "\t%s\t%.1f\n", rent.getMovie().getTitle(), rentalCost ));

			totalCost += rentalCost;
		}

		stringBuilder.append( String.format( "You owed %.1f\nYou earned %d frequent renter points\n", totalCost, loyaltyPoints));

		return stringBuilder.toString();
	}

}