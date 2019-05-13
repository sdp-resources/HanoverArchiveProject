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
    String title = "title";
    String id = "id";
    photo = new Photo(source, title, id);
  }

  @Test
  public void whenTitleIsEdited_ExpectNewPhotoTitle() throws Exception {
    String newTitle = "new title";
    photo.setTitle(newTitle);
    assertEquals(newTitle, photo.getTitle());
    assertEquals("source", photo.getSource());
    assertEquals("id", photo.getID());
  }

  @Test
  public void uploadNewPhoto() throws Exception {
    UploadPhoto uploadPhoto = new UploadPhoto();
  }
}
