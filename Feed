/**
 * @author Sara Liu
 * 10/1/20
 * Feed class, used to instantiate Feeds, get new Memes from the Feed, and run the main method
 */
import java.util.ArrayList;

public class Feed {
	//field
	private ArrayList<Meme> memes;

	/**
	 * no-argument constructor
	 */
	public Feed() {
		super();
		memes = new ArrayList<Meme>();
	}

	/**
	 * parameterized constructor
	 * @param memes
	 */
	public Feed(ArrayList<Meme> memes) {
		super();
		this.memes = memes;
	}
	
//	public static void main(String[] args) {
//		//Create a Feed object to house shared Memes
//		Feed feed = new Feed();
//		
//		//Create three (or more) user accounts
//		User derrick = new User("Derrick Stone");
//		User liam = new User("Liam");
//		User olivia = new User("Olivia");
//		
//		//Create three (or more) BackgroundImage objects
//		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
//		BackgroundImage sadKitten = new BackgroundImage("sadKitten", "Too sad", "Image of tearful kitten");
//		BackgroundImage success = new BackgroundImage("success", "Success kid", "Image of baby clenching fist with a determined facial expression");
//		
//		//Each user should create three Memes
//		derrick.createMeme(joker, "When your professor calls an in person meeting at 9 AM EST and you live in Cali");
//		derrick.createMeme(sadKitten, "When you laugh at insistence on comments in school and then get a job programming where nobody comments");
//		derrick.createMeme(success, "Walked into room; remembered why");
//		liam.createMeme(joker, "When you wake up at 6 AM for a meeting and realize it's actually at 6 PM");
//		liam.createMeme(sadKitten, "When you study for several hours and still fail");
//		liam.createMeme(success, "Didn't study; got an A");
//		olivia.createMeme(joker, "When you use an Uno reverse card");
//		olivia.createMeme(sadKitten, "When your application gets rejected");
//		olivia.createMeme(success, "Found a birthday card from 2 years ago; had 50 bucks on it");
//		
//		//Each user should share their Memes on the Feed
//		ArrayList<Meme> derrickMemes = derrick.getMemesCreated();
//		for(int i = 0; i < derrickMemes.size(); i++) {
//			derrick.shareMeme(derrickMemes.get(i), feed);
//		}
//		ArrayList<Meme> liamMemes = liam.getMemesCreated();
//		for(int i = 0; i < liamMemes.size(); i++) {
//			liam.shareMeme(liamMemes.get(i), feed);
//		}
//		ArrayList<Meme> oliviaMemes = olivia.getMemesCreated();
//		for(int i = 0; i < oliviaMemes.size(); i++) {
//			olivia.shareMeme(oliviaMemes.get(i), feed);
//		}
//		
//		//Each user should rate each meme with a randomly-generated score
//		while(feed.getNewMeme(derrick) != null) {
//			derrick.rateNextMeme(feed, (int)(Math.random() * 5) - 2); //generates random numbers between and including -2 and 2; (int) truncates, not rounds
//		}
//		while(feed.getNewMeme(liam) != null) {
//			liam.rateNextMeme(feed, (int)(Math.random() * 5) - 2);
//		}
//		while(feed.getNewMeme(olivia) != null) {
//			olivia.rateNextMeme(feed, (int)(Math.random() * 5) + 2);
//		}
//		
//		//Print out the Memes
//		System.out.println(feed);
//		
//		//Print out the Users
//		System.out.println(derrick);
//		System.out.println(liam);
//		System.out.println(olivia);
//	}
	
	//methods
	/**
	 * return a Meme from the current Feed that the User has not seen (does not exist in that User's memesViewed property) 
	 * and that the User did not create themselves
	 * @param user
	 * @return Meme
	 */
	public Meme getNewMeme(User user) {
		for(Meme meme: memes) {
			if(!user.getMemesViewed().contains(meme) && !user.getMemesCreated().contains(meme)) {
				return meme;
			}
		}
		return null;
	}
	
	/**
	 * returns all the memes in the feed, each Meme on a new line
	 * @return String
	 */
	@Override
	public String toString() {
		String allMemes = "";
		for(Meme meme: memes) {
			allMemes += meme.toString() + "\n";
		}
		return allMemes;
	}

	/**
	 * @return the memes
	 */
	public ArrayList<Meme> getMemes() {
		return memes;
	}

	/**
	 * @param memes the memes to set
	 */
	public void setMemes(ArrayList<Meme> memes) {
		this.memes = memes;
	}
}
