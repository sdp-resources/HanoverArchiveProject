import org.junit.Before;
import org.junit.Test;
import photoarchives.Photo;
import photoarchives.UploadPhoto;

import static junit.framework.TestCase.assertEquals;

public class PhotoTest {
  private Photo photo;

  @Before
  public void setUp() throws Exception {
    String source = "source";
    photo = new Photo(source);
  }

  @Test
  public void createDefaultImage() throws Exception {
    Photo p1 = new Photo();
    assertEquals(null, p1.getSource());
    assertEquals(null, p1.getID());
  }

  @Test
  public void uploadNewPhoto() throws Exception {
    UploadPhoto uploadPhoto = new UploadPhoto(photo);
  }

  @Test
  public void WhenPhotoIsReturned_EqualsPhoto() throws Exception {
    UploadPhoto uploadPhoto = new UploadPhoto(photo);
    assertEquals(photo, uploadPhoto.getPhoto());
  }

  @Test
  public void ImplementFilePath_ReceivePhoto() throws Exception {
   photo.setSource("/usr...");
   assertEquals("/usr...", photo.getSource());
  }


}
