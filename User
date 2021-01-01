/**
 * @author Sara Liu
 * 10/1/20
 * User class, used to instantiate Users; create, delete, share, and rate Memes; and calculate reputations 
 */
import java.util.ArrayList;

public class User {
	//fields
	private String userName;
	private ArrayList<Meme> memesCreated;
	private ArrayList<Meme> memesViewed;
	
	/**
	 * no-argument constructor
	 */
	public User() {
		super();
		userName = "";
		memesCreated = new ArrayList<Meme>();
		memesViewed = new ArrayList<Meme>();
	}

	/**
	 * parameterized constructor
	 * @param userName
	 */
	public User(String userName) {
		super();
		this.userName = userName;
		this.memesCreated = new ArrayList<Meme>();
		this.memesViewed = new ArrayList<Meme>();
	}

	//methods
	/**
	 * @param meme
	 * @param rating
	 */
//	public void rateMeme(Meme meme, int rating) {};
	
	/**
	 * creates a new Meme object using the supplied arguments and with the current user set as the creator property.
	 * adds the resulting Meme to the list of createdMemes variable for the current user. 
	 * @param image
	 * @param caption
	 * @return Meme
	 */
	public Meme createMeme(BackgroundImage image, String caption) {
		Meme meme = new Meme(image, caption, this);
		memesCreated.add(meme);
		return meme;
	}
	
	/**
	 * deletes this Meme if found in the memesCreated property for the current user, only if the shared property is false. 
	 * (Because anything shared on the Internet lives forever.)
	 * if Meme is deleted, return true; if Meme is not deleted, return false
	 * @param meme
	 * @return boolean
	 */
	public boolean deleteMeme(Meme meme) {
		if(memesCreated.contains(meme) && !meme.getShared()) {
			memesCreated.remove(meme);
			return true;
		}
		return false;
	}
	
	/**
	 * marks that Meme as shared (shared=true) and copies it to the memes ArrayList<Meme> data structure on the supplied Feed
	 * @param meme
	 * @param feed
	 */
	public void shareMeme(Meme meme, Feed feed) {
		meme.setShared(true);
		ArrayList<Meme> feedMemes = feed.getMemes();
		feedMemes.add(meme);
	};
	
	/**
	 * If there are no Memes left to view, print a message to the console and return (should not throw an error).
	 * get a Meme from the Feed using the getNewMeme(User) method of the Feed class. 
	 * record that Meme as having been seen and give it a ratingScore. 
	 * @param feed
	 * @param ratingScore
	 */
	public void rateNextMeme(Feed feed, int ratingScore) {
		if(feed.getNewMeme(this) == null) {
			System.out.println("No Memes left to view");
			return;
		}
		Meme meme = feed.getNewMeme(this);
		memesViewed.add(meme);
		ArrayList<Rating> memeRatings = meme.getRatings();
		Rating rating = new Rating(this, ratingScore);
		rating.setRating(ratingScore);
		memeRatings.add(rating);
	};
	
	/**
	 * returns a value calculated as a sum of all ratings (caclulateRating()) given to Memes created by this User. 
	 * If the user has not created any Memes or had any Memes rated, 0.0 should be returned.
	 * @return double
	 */
	public double calculateReputation() {
		double reputation = 0.0;
		for(Meme meme: memesCreated) {
			reputation += meme.calculateRating();
		}
		return reputation;
	}
	
	/**
	 * returns "username has rated (number of memes viewed) memes, (reputation)"
	 * @return String
	 */
	@Override
	public String toString() {
		return userName + " has rated (" + memesViewed.size() + ") memes, (" + calculateReputation() + ")";
	}

	/**
	 * if this references the same Object as obj, return true;
	 * if obj is not an instance of this type, return false (also returns false if obj has a null value);
	 * recast obj from Object to this type; 
	 * return true if the username matches
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the memesCreated
	 */
	public ArrayList<Meme> getMemesCreated() {
		return memesCreated;
	}

	/**
	 * @param memesCreated the memesCreated to set
	 */
	public void setMemesCreated(ArrayList<Meme> memesCreated) {
		this.memesCreated = memesCreated;
	}

	/**
	 * @return the memesViewed
	 */
	public ArrayList<Meme> getMemesViewed() {
		return memesViewed;
	}

	/**
	 * @param memesViewed the memesViewed to set
	 */
	public void setMemesViewed(ArrayList<Meme> memesViewed) {
		this.memesViewed = memesViewed;
	}
}
