import org.junit.jupiter.api.Assertions;
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

	@Test
	public void test_rental_regular_movie_2days(){
		Rental rent = new Rental(regularMovie,2 );
		Assertions.assertEquals(2, rent.getPrice());
	}

	@Test
	public void test_rental_regular_movie_3days(){
		Rental rent = new Rental(regularMovie,3 );
		Assertions.assertEquals(3.5, rent.getPrice());
	}

	@Test
	public void test_rental_children_movie_3days(){
		Rental rent = new Rental(childrenMovie,3 );
		Assertions.assertEquals(1.5, rent.getPrice());
	}

	@Test
	public void test_rental_children_movie_4days(){
		Rental rent = new Rental(childrenMovie,4 );
		Assertions.assertEquals(3, rent.getPrice());
	}

	@Test
	public void test_rental_newRelease_movie_1days(){
		Rental rent = new Rental(newReleaseMovie,3 );
		Assertions.assertEquals(3, rent.getPrice());
	}

	@Test
	public void test_rental_newRelease_movie_4days(){
		Rental rent = new Rental(newReleaseMovie,4 );
		Assertions.assertEquals(3, rent.getPrice());
	}

	@Test
	public void testSingleNewReleaseStatement(){
		customer.addRental( new Rental( new Movie("The Cell", MovieType.NEW_RELEASE), 3));
		Assertions.assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.statement());
	}
	@Test
	public void testDualNewReleaseStatement(){
		customer.addRental( new Rental( new Movie("The Cell", MovieType.NEW_RELEASE), 3));
		customer.addRental( new Rental( new Movie("The Tigger Movie", MovieType.NEW_RELEASE), 3));
		Assertions.assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.statement());
	}
	@Test
	public void testSingleChildrensStatement(){
		customer.addRental(new Rental (new Movie ("The Tigger Movie", MovieType.CHILDREN), 3));
		Assertions.assertEquals("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.statement());
	}
	@Test
	public void testMultipleRegularStatement(){
		customer.addRental( new Rental( new Movie("Plan 9 from Outer Space", MovieType.REGULAR), 1));
		customer.addRental( new Rental( new Movie("8 1/2", MovieType.REGULAR), 2));
		customer.addRental( new Rental( new Movie("Eraserhead", MovieType.REGULAR), 3));

		Assertions.assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.statement());
	}

}