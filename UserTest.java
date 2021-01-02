/**
 * @author Sara Liu
 * 10/2/20
 * UserTest JUnit 4 class, used to test User
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UserTest {

	@Test
	public void createMemeTest() {
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		User derrick = new User("Derrick Stone");
		Meme meme = new Meme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali", derrick);
		assertEquals("testing the createMeme method", meme, derrick.createMeme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali"));
	}
	
	@Test
	public void deleteMemeTest() {
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		User derrick = new User("Derrick Stone");
		derrick.createMeme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali");
		assertEquals("testing the deleteMeme method", true, derrick.deleteMeme(derrick.getMemesCreated().get(0)));
		derrick.createMeme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali");
		derrick.getMemesCreated().get(0).setShared(true);
		assertEquals("testing the deleteMeme method", false, derrick.deleteMeme(derrick.getMemesCreated().get(0)));
		User liam = new User("Liam");
		liam.createMeme(joker, "When you wake up at 6 AM for a meeting and realize it's actually at 6 PM");
		assertEquals("testing the deleteMeme method", false, derrick.deleteMeme(liam.getMemesCreated().get(0)));
	}
	
	@Test
	public void shareMemeTest() {
		Feed feed = new Feed();
		User derrick = new User("Derrick Stone");
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		derrick.createMeme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali");
		derrick.shareMeme(derrick.getMemesCreated().get(0), feed);
		assertEquals("testing the shareMeme method", derrick.getMemesCreated().get(0), feed.getMemes().get(0));
	}
	
	@Test
	public void rateNextMemeTest() {
		Feed feed = new Feed();
		User derrick = new User("Derrick Stone");
		User liam = new User("Liam");
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		BackgroundImage sadKitten = new BackgroundImage("sadKitten", "Too sad", "Image of tearful kitten");
		BackgroundImage success = new BackgroundImage("success", "Success kid", "Image of baby clenching fist with a determined facial expression");
		derrick.createMeme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali");
		liam.createMeme(joker, "When you wake up at 6 AM for a meeting and realize it's actually at 6 PM");
		liam.createMeme(sadKitten, "When you study for several hours and still fail");
		liam.createMeme(success, "Didn't study; got an A");
		ArrayList<Meme> derrickMemes = derrick.getMemesCreated();
		for(int i = 0; i < derrickMemes.size(); i++) {
			derrick.shareMeme(derrickMemes.get(i), feed);
		}
		ArrayList<Meme> liamMemes = liam.getMemesCreated();
		for(int i = 0; i < liamMemes.size(); i++) {
			liam.shareMeme(liamMemes.get(i), feed);
		}
		while(feed.getNewMeme(derrick) != null) {
			derrick.rateNextMeme(feed, (int)(Math.random() * 5) - 2);
		}
		derrick.rateNextMeme(feed, (int)(Math.random() * 5) - 2);
		assertNull("testing the rateNextMeme method", feed.getNewMeme(derrick));
	}
	
	@Test
	public void calculateReputationTest() {
		Feed feed = new Feed();
		User derrick = new User("Derrick Stone");
		User liam = new User("Liam");
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		BackgroundImage sadKitten = new BackgroundImage("sadKitten", "Too sad", "Image of tearful kitten");
		BackgroundImage success = new BackgroundImage("success", "Success kid", "Image of baby clenching fist with a determined facial expression");
		derrick.createMeme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali");
		liam.createMeme(joker, "When you wake up at 6 AM for a meeting and realize it's actually at 6 PM");
		liam.createMeme(sadKitten, "When you study for several hours and still fail");
		liam.createMeme(success, "Didn't study; got an A");
		ArrayList<Meme> derrickMemes = derrick.getMemesCreated();
		for(int i = 0; i < derrickMemes.size(); i++) {
			derrick.shareMeme(derrickMemes.get(i), feed);
		}
		ArrayList<Meme> liamMemes = liam.getMemesCreated();
		for(int i = 0; i < liamMemes.size(); i++) {
			liam.shareMeme(liamMemes.get(i), feed);
		}
		while(feed.getNewMeme(derrick) != null) {
			derrick.rateNextMeme(feed, 1);
		}
		assertEquals("testing the calculateReputation method", 3.0, liam.calculateReputation(), 0.0);
	}
	
	@Test
	public void toStringTest() {
		User derrick = new User("Derrick Stone");
		assertEquals("testing the toString method", "Derrick Stone has rated (0) memes, (0.0)", derrick.toString());
	}
	
	@Test
	public void equalsTest() {
		User derrick = new User("Derrick Stone");
		User liam = derrick;
		assertTrue("aliased objects should be equal", derrick.equals(liam));
		User olivia = null;
		assertFalse("Null as an argument to equals should return false", derrick.equals(olivia));
		
		olivia = new User();
		assertFalse("Different Users should not be equal (argument User is empty)", derrick.equals(olivia));
		olivia.setUserName("Derrick Stone");
		assertTrue("Users with the same data should be equal", derrick.equals(olivia));
		derrick.setUserName(null);
		assertFalse("Users with different userNames (one null) should not be equal", derrick.equals(olivia));
		olivia.setUserName(null);
		assertTrue("Users with the same data should be equal", derrick.equals(olivia));
	}
	
	@Test
	public void setAndGetUserNameTest() {
		User derrick = new User();
		derrick.setUserName("Derrick Stone");
		assertEquals("User userName set and get not functioning", "Derrick Stone", derrick.getUserName());
		assertEquals("setting and getting title should not affect memesCreated", new ArrayList<Meme>(), derrick.getMemesCreated());
		assertEquals("setting and getting title should not affect memesViewed", new ArrayList<Meme>(), derrick.getMemesViewed());
	}
	
	@Test
	public void setAndGetMemesCreatedTest() {
		User derrick = new User("Derrick Stone");
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		Meme meme = new Meme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali", derrick);
		ArrayList<Meme> memesCreatedArray = new ArrayList<Meme>();
		memesCreatedArray.add(meme);
		derrick.setMemesCreated(memesCreatedArray);
		assertEquals("User memesCreated set and get not functioning", memesCreatedArray, derrick.getMemesCreated());
		assertEquals("setting and getting title should not affect userName", "Derrick Stone", derrick.getUserName());
		assertEquals("setting and getting title should not affect memesViewed", new ArrayList<Meme>(), derrick.getMemesViewed());
	}
	
	@Test
	public void setAndGetMemesViewedTest() {
		User derrick = new User("Derrick Stone");
		User liam = new User("Liam");
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		Meme meme = new Meme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali", liam);
		ArrayList<Meme> memesViewedArray = new ArrayList<Meme>();
		memesViewedArray.add(meme);
		derrick.setMemesViewed(memesViewedArray);
		assertEquals("User memesViewed set and get not functioning", memesViewedArray, derrick.getMemesViewed());
		assertEquals("setting and getting title should not affect userName", "Derrick Stone", derrick.getUserName());
		assertEquals("setting and getting title should not affect memesCreated", new ArrayList<Meme>(), derrick.getMemesCreated());
	}
	
	@Test
	public void userTest() {
		User derrick = new User("Derrick Stone");
		assertNotNull("Constructor is null", derrick);
		assertEquals("Constructor not instantiating userName in User properly", "Derrick Stone", derrick.getUserName());
		assertEquals("Constructor not instantiating memesCreated in User properly", new ArrayList<Meme>(), derrick.getMemesCreated());
		assertEquals("Constructor not instantiating memesViewed in User properly", new ArrayList<Meme>(), derrick.getMemesViewed());
	}
}
