/**
 * @author Sara Liu
 * BackgroundImageTest JUnit 4 class, used to test BackgroundImage
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class BackgroundImageTest {

	@Test
	public void toStringTest() {
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		assertEquals("testing the toString method", "How bots laugh <Image of Joquain Phoenix in his role as Joker, laughing maniacally>", joker.toString());
	}
	
	@Test
	public void equalsTest() {
		BackgroundImage joker = new BackgroundImage();
		joker.setImageFileName("joker");
		joker.setTitle("How bots laugh");
		joker.setDescription("Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		BackgroundImage joker2 = joker;
		assertTrue("aliased objects should be equal", joker.equals(joker2));
		BackgroundImage sadKitten = null;
		assertFalse("Null as an argument to equals should return false", joker.equals(sadKitten));
		
		sadKitten = new BackgroundImage();
		assertFalse("Different BackgroundImages should not be equal (argument BackgroundImage is empty)", joker.equals(sadKitten));
		sadKitten.setDescription("Image of tearful kitten");
		sadKitten.setImageFileName(joker.getImageFileName());
		sadKitten.setTitle(joker.getTitle());
		assertFalse("BackgroundImages with different descriptions should not be equal", joker.equals(sadKitten));
		joker.setDescription(null);
		assertFalse("BackgroundImages with different descriptions (one null) should not be equal", joker.equals(sadKitten));
		sadKitten.setDescription(null);
		assertTrue("BackgroundImages with null descriptions should be equal", joker.equals(sadKitten));
		joker.setDescription("Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		sadKitten.setDescription("Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		assertTrue("BackgroundImages with the same data should be equal", joker.equals(sadKitten));
		
		sadKitten.setImageFileName("sadKitten");
		assertFalse("BackgroundImages with different imageFileNames should not be equal", joker.equals(sadKitten));
		joker.setImageFileName(null);
		assertFalse("BackgroundImages with different imageFileNames (one null) should not be equal", joker.equals(sadKitten));
		sadKitten.setImageFileName(null);
		assertTrue("BackgroundImages with null imageFileNames should be equal", joker.equals(sadKitten));
		
		sadKitten.setTitle("Too sad");
		assertFalse("BackgroundImages with different titles should not be equal", joker.equals(sadKitten));
		joker.setTitle(null);
		assertFalse("BackgroundImages with different titles (one null) should not be equal", joker.equals(sadKitten));
		sadKitten.setTitle(null);
		assertTrue("BackgroundImages with null titles should be equal", joker.equals(sadKitten));
	}
	
	@Test
	public void setAndGetImageFileNameTest() {
		BackgroundImage joker = new BackgroundImage();
		joker.setImageFileName("joker");
		assertEquals("BackgroundImage imageFileName set and get not functioning", "joker", joker.getImageFileName());
		assertEquals("setting and getting imageFileName should not affect title", "", joker.getTitle());
		assertEquals("setting and getting imageFileName should not affect description", "", joker.getDescription());
	}
	
	@Test
	public void setAndGetTitleTest() {
		BackgroundImage joker = new BackgroundImage();
		joker.setTitle("How bots laugh");
		assertEquals("BackgroundImage title set and get not functioning", "How bots laugh", joker.getTitle());
		assertEquals("setting and getting title should not affect imageFileName", "", joker.getImageFileName());
		assertEquals("setting and getting title should not affect description", "", joker.getDescription());
	}
	
	@Test
	public void setAndGetDescriptionTest() {
		BackgroundImage joker = new BackgroundImage();
		joker.setDescription("Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		assertEquals("BackgroundImage description set and get not functioning","Image of Joquain Phoenix in his role as Joker, laughing maniacally", joker.getDescription());
		assertEquals("setting and getting description should not affect imageFileName", "", joker.getImageFileName());
		assertEquals("setting and getting description should not affect title", "", joker.getTitle());
	}
	
	//constructor tests optional in this homework assignment
	@Test
	public void backgroundImageTest() {
		BackgroundImage joker = new BackgroundImage("joker", "How bots laugh", "Image of Joquain Phoenix in his role as Joker, laughing maniacally");
		assertNotNull("Constructor is null", joker);
		assertEquals("Constructor not instantiating imageFileName in BackgroundImage properly", "joker", joker.getImageFileName());
		assertEquals("Constructor not instantiating title in BackgroundImage properly", "How bots laugh", joker.getTitle());
		assertEquals("Constructor not instantiating description in BackgroundImage properly","Image of Joquain Phoenix in his role as Joker, laughing maniacally", joker.getDescription());
	}
}
