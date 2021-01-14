import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VideoStoreTest
{
	private final Customer customer;

	private final Movie regularMovie = new Movie("regular movie title", MovieType.REGULAR);
	private final Movie childrenMovie = new Movie("children movie title", MovieType.CHILDREN);
	private final Movie newReleaseMovie = new Movie("new release movie title", MovieType.NEW_RELEASE);

	public VideoStoreTest(){
		customer = new Customer("Fred");
	}

	@BeforeEach
	public void resetCustomer(){
		customer.resetAllRent();
	}

	@Test
	public void test_rental_regular_movie_2days(){
		Rental rent = new Rental(regularMovie,2, customer, 0 );
		Assertions.assertEquals(2, rent.getPrice());
	}

	@Test
	public void test_rental_regular_movie_3days(){
		Rental rent = new Rental(regularMovie,3, customer, 0 );
		Assertions.assertEquals(3.5, rent.getPrice());
	}

	@Test
	public void test_rental_children_movie_3days(){
		Rental rent = new Rental(childrenMovie,3 , customer, 0);
		Assertions.assertEquals(1.5, rent.getPrice());
	}

	@Test
	public void test_rental_children_movie_4days(){
		Rental rent = new Rental(childrenMovie,4 , customer, 0);
		Assertions.assertEquals(3, rent.getPrice());
	}

	@Test
	public void test_rental_newRelease_movie_1days(){
		Rental rent = new Rental(newReleaseMovie,3 , customer, 0);
		Assertions.assertEquals(9, rent.getPrice());
	}

	@Test
	public void test_rental_newRelease_movie_4days(){
		Rental rent = new Rental(newReleaseMovie,4 , customer, 0);
		Assertions.assertEquals(12, rent.getPrice());
	}

	@Test
	public void test_rental_regular_movie_1_loyalty_point(){
		Rental rent = new Rental(regularMovie,4 , customer, 0);
		Assertions.assertEquals(1, rent.getLoyaltyPoints());
	}

	@Test
	public void test_rental_children_movie_1_loyalty_point(){
		Rental rent = new Rental(childrenMovie,4, customer, 0 );
		Assertions.assertEquals(1, rent.getLoyaltyPoints());

	}

	@Test
	public void test_rental_newRelease_movie_1_loyalty_point(){
		Rental rent = new Rental(newReleaseMovie,1 , customer, 0);
		Assertions.assertEquals(1, rent.getLoyaltyPoints());

	}

	@Test
	public void test_rental_newRelease_movie_2_loyalty_point(){
		Rental rent = new Rental(newReleaseMovie,2, customer, 0 );
		Assertions.assertEquals(2, rent.getLoyaltyPoints());
	}

	@Test
	public void test_rental_newRelease_movie_using_3_loyalty_point(){
		customer.setLoyaltyPoints(4);
		customer.addRental(newReleaseMovie, 2, 3);
		Assertions.assertEquals(3, customer.getLoyaltyPoints());
		Assertions.assertEquals(4.2, customer.getRentals().get(0).getPrice(), 0.001); // delta 0.001 because with low number with some errors -> we get 4.19999999999999
	}

	@Test
	public void test_rental_newRelease_movie_using_2_loyalty_point(){
		customer.setLoyaltyPoints(2);
		customer.addRental(newReleaseMovie, 1, 3);
		Assertions.assertEquals(1, customer.getLoyaltyPoints());
		Assertions.assertEquals(2.4, customer.getRentals().get(0).getPrice(), 0.001); // delta 0.001 because with low number with some errors -> we get 2.400000000000000004
	}

	@Test
	public void testSingleNewReleaseStatement(){
		customer.addRental( new Movie("The Cell", MovieType.NEW_RELEASE), 3, 0);
		String expected = String.format("Rental Record for Fred\n\tThe Cell\t%.1f\nYou owed %.1f\nYou earned 2 frequent renter points\n", 9.0, 9.0);
		Assertions.assertEquals(expected, customer.statement());
	}
	@Test
	public void testDualNewReleaseStatement(){
		customer.addRental( new Movie("The Cell", MovieType.NEW_RELEASE), 3, 0);
		customer.addRental( new Movie("The Tigger Movie", MovieType.NEW_RELEASE), 3, 0);
		String expected = String.format("Rental Record for Fred\n\tThe Cell\t%.1f\n\tThe Tigger Movie\t%.1f\nYou owed %.1f\nYou earned 4 frequent renter points\n", 9.0, 9.0, 18.0);
		Assertions.assertEquals(expected, customer.statement());
	}
	@Test
	public void testSingleChildrensStatement(){
		customer.addRental( new Movie ("The Tigger Movie", MovieType.CHILDREN), 3, 0);
		String expected = String.format("Rental Record for Fred\n\tThe Tigger Movie\t%.1f\nYou owed %.1f\nYou earned 1 frequent renter points\n", 1.5, 1.5);
		Assertions.assertEquals(expected, customer.statement());
	}
	@Test
	public void testMultipleRegularStatement(){
		customer.addRental( new Movie("Plan 9 from Outer Space", MovieType.REGULAR), 1, 0);
		customer.addRental( new Movie("8 1/2", MovieType.REGULAR), 2, 0);
		customer.addRental( new Movie("Eraserhead", MovieType.REGULAR), 3, 0);
		String expected = String.format("Rental Record for Fred\n\tPlan 9 from Outer Space\t%.1f\n\t8 1/2\t%.1f\n\tEraserhead\t%.1f\nYou owed %.1f\nYou earned 3 frequent renter points\n", 2.0, 2.0, 3.5, 7.5);
		Assertions.assertEquals(expected, customer.statement());
	}

}