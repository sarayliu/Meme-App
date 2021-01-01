/**
 * @author Sara Liu
 * 10/2/20
 * MemeTest JUnit 4 class, used to test Meme
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MemeTest {

	@Test
	public void toStringTest() {
		User derrick = new User("Derrick Stone");
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		Meme meme = new Meme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali", derrick);
		assertEquals("testing the toString method", "How bots laugh <Image of Joquain Phoenix in his role as Joker, laughing maniacally> 'When your professor calls an in person meeting at 9 AM EST and you live in Cali' Derrick Stone (0.0) 0.0 [(0) +1 (0) -1]", meme.toString());
	}

	@Test
	public void equalsTest() {
		Meme meme = new Meme();
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		meme.setBackgroundImage(joker);
		meme.setCaption("When your professor calls an in person meeting at 9 AM EST and you live in Cali");
		User derrick = new User("Derrick Stone");
		meme.setCreator(derrick);
		Meme meme2 = meme;
		assertTrue("aliased objects should be equal", meme.equals(meme2));
		Meme meme3 = null;
		assertFalse("Null as an argument to equals should return false", meme.equals(meme3));
		
		meme3 = new Meme();
		assertFalse("Different Memes should not be equal (argument Meme is empty)", meme.equals(meme3));
		BackgroundImage sadKitten = new BackgroundImage("sadKitten", "Too sad", "Image of tearful kitten");
		meme3.setBackgroundImage(sadKitten);
		meme3.setCaption(meme.getCaption());
		meme3.setCreator(meme.getCreator());
		assertFalse("Memes with different backgroundImages should not be equal", meme.equals(meme3));
		meme.setBackgroundImage(null);
		assertFalse("Memes with different backgroundImages (one null) should not be equal", meme.equals(meme3));
		meme3.setBackgroundImage(null);
		assertTrue("Memes with null backgroundImages should be equal", meme.equals(meme3));
		meme.setBackgroundImage(joker);
		meme3.setBackgroundImage(joker);
		assertTrue("Memes with the same data should be equal", meme.equals(meme3));
		
		meme3.setCaption("When you laugh at insistence on comments in school and then get a job programming where nobody comments");
		assertFalse("Memes with different captions should not be equal", meme.equals(meme3));
		meme.setCaption(null);
		assertFalse("Memes with different captions (one null) should not be equal", meme.equals(meme3));
		meme3.setCaption(null);
		assertTrue("Memes with null captions should be equal", meme.equals(meme3));
		
		User liam = new User("Liam");
		meme3.setCreator(liam);
		assertFalse("Memes with different creators should not be equal", meme.equals(meme3));
		meme.setCreator(null);
		assertFalse("Memes with different creators (one null) should not be equal", meme.equals(meme3));
		meme3.setCreator(null);
		assertTrue("Memes with null creators should be equal", meme.equals(meme3));
	}
	
	@Test
	public void calculateRatingTest() {
		Meme meme = new Meme();
		User derrick = new User("Derrick Stone");
		Rating memeRating = new Rating(derrick, 1);
		ArrayList<Rating> ratingArray = new ArrayList<Rating>();
		ratingArray.add(memeRating);
		meme.setRatings(ratingArray);
		assertEquals("testing the calculateRating method", 1.0, meme.calculateRating(), 0.0);
		
	}
	
	@Test
	public void countRatingsTest() {
		Meme meme = new Meme();
		User derrick = new User("Derrick Stone");
		User liam = new User("Liam");
		User olivia = new User("olivia");
		Rating derrickRating = new Rating(derrick, 1);
		Rating liamRating = new Rating(liam, -1);
		Rating oliviaRating = new Rating(olivia, 0);
		ArrayList<Rating> ratingArray = new ArrayList<Rating>();
		ratingArray.add(derrickRating);
		ratingArray.add(liamRating);
		ratingArray.add(oliviaRating);
		meme.setRatings(ratingArray);
		assertArrayEquals("testing the countRatings method", new int[] {1, 1}, meme.countRatings());
	}
	
	@Test
	public void setAndGetCreatorTest() {
		Meme meme = new Meme();
		User derrick = new User("Derrick Stone");
		meme.setCreator(derrick);
		assertEquals("Meme creator set and get not functioning", derrick, meme.getCreator());
		assertEquals("setting and getting title should not affect backgroundImage", new BackgroundImage(), meme.getBackgroundImage());
		assertEquals("setting and getting title should not affect ratings", new ArrayList<Rating>(), meme.getRatings());
		assertEquals("setting and getting title should not affect caption", "", meme.getCaption());
		assertEquals("setting and getting title should not affect shared", false, meme.getShared());
	}
	
	@Test
	public void setAndGetBackgroundImageTest() {
		Meme meme = new Meme();
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		meme.setBackgroundImage(joker);
		assertEquals("Meme backgroundImage set and get not functioning", joker, meme.getBackgroundImage());
		assertEquals("setting and getting title should not affect creator", new User(), meme.getCreator());
		assertEquals("setting and getting title should not affect ratings", new ArrayList<Rating>(), meme.getRatings());
		assertEquals("setting and getting title should not affect caption", "", meme.getCaption());
		assertEquals("setting and getting title should not affect shared", false, meme.getShared());
	}
	
	@Test
	public void setAndGetRatingsTest() {
		Meme meme = new Meme();
		User derrick = new User("Derrick Stone");
		Rating memeRating = new Rating(derrick, 1);
		ArrayList<Rating> ratingArray = new ArrayList<Rating>();
		ratingArray.add(memeRating);
		meme.setRatings(ratingArray);
		assertEquals("Meme ratings set and get not functioning", ratingArray, meme.getRatings());
		assertEquals("setting and getting title should not affect creator", new User(), meme.getCreator());
		assertEquals("setting and getting title should not affect backgroundImage", new BackgroundImage(), meme.getBackgroundImage());
		assertEquals("setting and getting title should not affect caption", "", meme.getCaption());
		assertEquals("setting and getting title should not affect shared", false, meme.getShared());
	}
	
	@Test
	public void setAndGetCaptionTest() {
		Meme meme = new Meme();
		meme.setCaption("hello");
		assertEquals("Meme caption set and get not functioning", "hello", meme.getCaption());
		assertEquals("setting and getting title should not affect creator", new User(), meme.getCreator());
		assertEquals("setting and getting title should not affect backgroundImage", new BackgroundImage(), meme.getBackgroundImage());
		assertEquals("setting and getting title should not affect ratings", new ArrayList<Rating>(), meme.getRatings());
		assertEquals("setting and getting title should not affect shared", false, meme.getShared());
	}
	
	@Test
	public void setAndGetSharedTest() {
		Meme meme = new Meme();
		meme.setShared(true);
		assertEquals("Meme shared set and get not functioning", true, meme.getShared());
		assertEquals("setting and getting title should not affect creator", new User(), meme.getCreator());
		assertEquals("setting and getting title should not affect backgroundImage", new BackgroundImage(), meme.getBackgroundImage());
		assertEquals("setting and getting title should not affect ratings", new ArrayList<Rating>(), meme.getRatings());
		assertEquals("setting and getting title should not affect caption", "", meme.getCaption());
	}
	
	@Test
	public void memeTest() {
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		User derrick = new User("Derrick Stone");
		Meme meme = new Meme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali", derrick);
		assertNotNull("Constructor is null", meme);
		assertEquals("Constructor not instantiating backgroundImage in Meme properly", joker, meme.getBackgroundImage());
		assertEquals("Constructor not instantiating caption in Meme properly", "When your professor calls an in person meeting at 9 AM EST and you live in Cali", meme.getCaption());
		assertEquals("Constructor not instantiating creator in Meme properly", derrick, meme.getCreator());
		assertEquals("Constructor not instantiating ratings in Meme properly", new ArrayList<Rating>(), meme.getRatings());
		assertEquals("Constructor not instantiating shared in Meme properly", false, meme.getShared());
	}
}
