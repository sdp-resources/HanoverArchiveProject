import org.junit.Before;
import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoUploader;

import static junit.framework.TestCase.assertEquals;

public class PhotoTest {
  private Photo photo;

  @Before
  public void setUp() {
    String source = "source";
    photo = new Photo(source);
  }

  @Test
  public void createDefaultImage() {
    Photo p1 = new Photo();
    assertEquals(null, p1.getSource());
    assertEquals(null, p1.getID());
  }

  @Test
  public void createImageWithGivenSource() {
    assertEquals("source", photo.getSource());
    assertEquals(null, photo.getID());
  }


  @Test
  public void setNewSource_ExpectChange() {
   photo.setSource("/usr...");
   assertEquals("/usr...", photo.getSource());
  }

  @Test
  public void setNewID_ExpectChange() {
    String testID = "001";
    photo.setID(testID);
    assertEquals(testID, photo.getID());
  }


}
