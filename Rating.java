/**
 * @author Sara Liu
 * 10/1/20
 * Rating class, used to instantiate Ratings and set Ratings
 */
public class Rating {
	//fields
	private int score;
	private User user;
	
	/**
	 * no-argument constructor
	 */
	public Rating() {
		super();
		score = 0;
		user = new User();
	}

	/**
	 * parameterized constructor
	 * @param user
	 * @param score
	 */
	public Rating(User user, int score) {
		super();
		this.user = user;
		this.score = score;
	}
	
	//methods
	/**
	 * returns "username rates score"
	 * @return String
	 */
	@Override
	public String toString() {
		return user.getUserName() + " rates " + score;
	}

	/**
	 * if this references the same Object as obj, return true;
	 * if obj is not an instance of this type, return false (also returns false if obj has a null value);
	 * recast obj from Object to this type; 
	 * returns true if score and user are equal
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rating))
			return false;
		Rating other = (Rating) obj;
		if (score != other.score)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	/**
	 * Users can upvote, downvote or pass on a rating, giving a score of +1, -1, or 0, respectively. 
	 * This method will only accept those values (any positive int becomes +1, any negative int becomes -1)
	 * @param rating
	 */
	public void setRating(int rating) {
		if(rating > 0) {
			score = 1;
		}
		else if(rating < 0) {
			score = -1;
		}
		else {
			score = 0;
		}
	}
	
	/**
	 * @return the score
	 */
	public int getRating() {
		return score;
	}

//	/**
//	 * @return the score
//	 */
//	public int getScore() {
//		return score;
//	}
//
//	/**
//	 * @param score the score to set
//	 */
//	public void setScore(int score) {
//		if(score > 0) {
//			this.score = 1;
//		}
//		else if(score < 0) {
//			this.score = -1;
//		}
//		else {
//			this.score = 0;
//		}
//	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
