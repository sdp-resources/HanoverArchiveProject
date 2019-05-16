import org.junit.Before;
import org.junit.Test;
import photoarchives.Photo;


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
    assertEquals(null, p1.getUploadedFrom());
    assertEquals(null, p1.getID());
    assertEquals(0, p1.getLabels().size());
  }

  @Test
  public void createImageWithGivenSource() {
    assertEquals("source", photo.getUploadedFrom());
    assertEquals(null, photo.getID());
  }


  @Test
  public void setNewSource_ExpectChange() {
   photo.setUploadedFrom("/usr...");
   assertEquals("/usr...", photo.getUploadedFrom());
  }

  @Test
  public void setNewID_ExpectChange() {
    String testID = "001";
    photo.setID(testID);
    assertEquals(testID, photo.getID());
  }


}
