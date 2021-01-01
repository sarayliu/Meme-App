/**
 * @author Sara Liu
 * 10/2/20
 * RatingTest JUnit 4 class, used to test Rating
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class RatingTest {

	@Test
	public void toStringTest() {
		User derrick = new User("Derrick Stone");
		Rating rating = new Rating(derrick, 1);
		assertEquals("testing the toString method", "Derrick Stone rates 1", rating.toString());
	}
	
	@Test
	public void equalsTest() {
		Rating rating = new Rating();
		rating.setRating(1);
		User derrick = new User("Derrick Stone");
		rating.setUser(derrick);
		Rating rating2 = rating;
		assertTrue("aliased objects should be equal", rating.equals(rating2));
		Rating rating3 = null;
		assertFalse("Null as an argument to equals should return false", rating.equals(rating3));
		
		rating3 = new Rating();
		assertFalse("Different Ratings should not be equal (argument Rating is empty)", rating.equals(rating3));
		rating3.setRating(-1);
		assertFalse("Ratings with different scores should not be equal", rating.equals(rating3));
		User liam = new User("Liam");
		rating3.setUser(liam);
		rating3.setRating(rating.getRating());
		assertFalse("Ratings with different users should not be equal", rating.equals(rating3));
		rating.setUser(null);
		assertFalse("Ratings with different users (one null) should not be equal", rating.equals(rating3));
		rating3.setUser(null);
		assertTrue("Ratings with null users should be equal", rating.equals(rating3));
		rating.setUser(derrick);
		rating3.setUser(derrick);
		assertTrue("Ratings with the same data should be equal", rating.equals(rating3));
	}
	
	@Test
	public void setAndGetRatingTest() {
		Rating rating = new Rating();
		rating.setRating(1);
		assertEquals("Rating score set and get not functioning", 1, rating.getRating());
		assertEquals("setting and getting title should not affect user", new User(), rating.getUser());
		rating.setRating(-1);
		assertEquals("Rating score set and get not functioning", -1, rating.getRating());
		rating.setRating(0);
		assertEquals("Rating score set and get not functioning", 0, rating.getRating());
	}
	
	@Test
	public void setAndGetUserTest() {
		Rating rating = new Rating();
		User derrick = new User("Derrick Stone");
		rating.setUser(derrick);
		assertEquals("Rating user set and get not functioning", derrick, rating.getUser());
		assertEquals("setting and getting title should not affect score", 0, rating.getRating());
	}
	
	@Test
	public void ratingTest() {
		User derrick = new User("Derrick Stone");
		Rating rating = new Rating(derrick, 1);
		assertNotNull("Constructor is null", rating);
		assertEquals("Constructor not instantiating user in Rating properly", derrick, rating.getUser());
		assertEquals("Constructor not instantiating score in Rating properly", 1, rating.getRating());
	}
}
