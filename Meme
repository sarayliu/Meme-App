/**
 * @author Sara Liu
 * 10/1/20
 * Meme class, used to instantiate Memes and calculate their Ratings
 */
import java.util.ArrayList;

public class Meme {
	//fields
	private User creator;
	private BackgroundImage backgroundImage;
	private ArrayList<Rating> ratings;
	private String caption;
	private boolean shared;
	
	/**
	 * no-argument constructor
	 */
	public Meme() {
		super();
		creator = new User();
		backgroundImage = new BackgroundImage();
		ratings = new ArrayList<Rating>();
		caption = "";
		shared = false;
	}

	/**
	 * parameterized constructor
	 * @param backgroundImage
	 * @param caption
	 * @param creator
	 */
	public Meme(BackgroundImage backgroundImage, String caption, User creator) {
		super();
		this.backgroundImage = backgroundImage;
		this.caption = caption;
		this.creator = creator;
		this.ratings = new ArrayList<Rating>();
		this.shared = false;
	}
	
	//methods
	/**
	 * returns "backgroundImage 'caption' userName (reputation) meme calculated rating [(number of +1 ratings) +1 (number of -1 ratings) -1]"
	 * @return String
	 */
	@Override
	public String toString() {
		int[] ratingCounts = countRatings();
		return backgroundImage.toString() + " '" + caption + "' " + creator.getUserName() + " (" + creator.calculateReputation() + ") " 
				+ calculateRating() + " [(" + ratingCounts[0] + ") +1 (" + ratingCounts[1] + ") -1]";
	}
	
	/**
	 * if this references the same Object as obj, return true;
	 * if obj is not an instance of this type, return false (also returns false if obj has a null value);
	 * recast obj from Object to this type; 
	 * return true if creator, caption and backgroundImage are equal
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Meme))
			return false;
		Meme other = (Meme) obj;
		if (backgroundImage == null) {
			if (other.backgroundImage != null)
				return false;
		} else if (!backgroundImage.equals(other.backgroundImage))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		return true;
	}
	
	/**
	 * return a double that is a sum of all rating scores for this Meme. If a Meme has no ratings, 0.0 should be returned.
	 * @return double
	 */
	public double calculateRating() {
		double ratingSum = 0.0;
		for(Rating rating: ratings) {
			ratingSum += rating.getRating();
		}
		return ratingSum;
	}
	
	/**
	 * returns the number of +1 and -1 ratings
	 * @return int[] = {plusOneCount, minusOneCount}
	 */
	public int[] countRatings() {
		int plusOneCount = 0;
		int minusOneCount = 0;
		for(Rating rating: ratings) {
			if(rating.getRating() == 1) {
				plusOneCount++;
			}
			else if(rating.getRating() == -1) {
				minusOneCount++;
			}
		}
		return new int[] {plusOneCount, minusOneCount};
	}

	/**
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}

	/**
	 * @return the backgroundImage
	 */
	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * @param backgroundImage the backgroundImage to set
	 */
	public void setBackgroundImage(BackgroundImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	/**
	 * @return the ratings
	 */
	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * @return the shared
	 */
	public boolean getShared() {
		return shared;
	}

	/**
	 * @param shared the shared to set
	 */
	public void setShared(boolean shared) {
		this.shared = shared;
	}
}
