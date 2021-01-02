/**
 * @author Sara Liu
 * 10/2/20
 * FeedTest JUnit 4 class, used to test Feed
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FeedTest {

	@Test
	public void getNewMemeTest() {
		Feed feed = new Feed();
		User derrick = new User("Derrick Stone");
		assertEquals("testing the getNewMeme method", null, feed.getNewMeme(derrick));
		User liam = new User("Liam");
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		BackgroundImage sadKitten = new BackgroundImage("sadKitten", "Too sad", "Image of tearful kitten");
		BackgroundImage success = new BackgroundImage("success", "Success kid", "Image of baby clenching fist with a determined facial expression");
		derrick.createMeme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali");
		derrick.createMeme(sadKitten, "When you laugh at insistence on comments in school and then get a job programming where nobody comments");
		derrick.createMeme(success, "Walked into room; remembered why");
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
		
		//getNewMeme iterates past Memes created by derrick (but they were not viewed by derrick)
		//derrick did not view the joker Meme from liam before, and derrick did not create the joker Meme
		assertEquals("testing the getNewMeme method", new Meme(joker, "When you wake up at 6 AM for a meeting and realize it's actually at 6 PM", liam), feed.getNewMeme(derrick)); 
		
		derrick.rateNextMeme(feed, 1); //derrick rates joker Meme from liam
		derrick.rateNextMeme(feed, 1); //derrick rates sadKitten Meme from liam
		
		//getNewMeme iterates past sadKitten Meme from liam, which derrick viewed but did not create
		assertEquals("testing the getNewMeme method", new Meme(success, "Didn't study; got an A", liam), feed.getNewMeme(derrick)); 
		
		//according to JUnit coverage, all four branches covered. So code also tested getting a Meme that the user both viewed and created?
	}
	
	@Test
	public void toStringTest() {
		Feed feed = new Feed();
		assertEquals("testing the toString method", "", feed.toString());
		User derrick = new User("Derrick Stone");
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		derrick.createMeme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali");
		derrick.shareMeme(derrick.getMemesCreated().get(0), feed);
		assertEquals("testing the toString method", "How bots laugh <Image of Joquain Phoenix in his role as Joker, laughing maniacally> 'When your professor calls an in person meeting at 9 AM EST and you live in Cali' Derrick Stone (0.0) 0.0 [(0) +1 (0) -1]\n", feed.toString());
	}
	
	@Test
	public void setAndGetMemes() {
		ArrayList<Meme> feedMemes = new ArrayList<Meme>();
		feedMemes.add(new Meme());
		Feed feed = new Feed(feedMemes);
		assertEquals("Feed meme set and get not functioning", feedMemes, feed.getMemes());
		feedMemes.add(new Meme());
		feed.setMemes(feedMemes);
		assertEquals("Feed meme set and get not functioning", feedMemes, feed.getMemes());
	}
	
	@Test
	public void feedTest() {
		ArrayList<Meme> feedMemes = new ArrayList<Meme>();
		feedMemes.add(new Meme());
		Feed feed = new Feed(feedMemes);
		assertNotNull("Constructor is null", feed);
		assertEquals("Constructor not instantiating memes in Feed properly", feedMemes, feed.getMemes());
	}
}
