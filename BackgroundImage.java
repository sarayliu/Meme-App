/**
 * @author Sara Liu
 * 10/1/20
 * BackgroundImage class, used to instantiate BackgroundImages
 */
public class BackgroundImage {
	//fields
	private String imageFileName;
	private String title;
	private String description;
	
	/**
	 * no-argument constructor
	 */
	public BackgroundImage() {
		super();
		imageFileName = "";
		title = "";
		description = "";
	}

	/**
	 * parameterized constructor
	 * @param imageFileName
	 * @param title
	 * @param description
	 */
	public BackgroundImage(String imageFileName, String title, String description) {
		super();
		this.imageFileName = imageFileName;
		this.title = title;
		this.description = description;
	}
	
	//methods
	/**
	 * returns "title <description>"
	 * @return String
	 */
	@Override
	public String toString() {
		return title + " <" + description + ">";
	}
	
	/**
	 * if this references the same Object as obj, return true;
	 * if obj is not an instance of this type, return false (also returns false if obj has a null value);
	 * recast obj from Object to this type; 
	 * return true if title, description, imageFileName all match
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof BackgroundImage))
			return false;
		BackgroundImage other = (BackgroundImage) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (imageFileName == null) {
			if (other.imageFileName != null)
				return false;
		} else if (!imageFileName.equals(other.imageFileName))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
