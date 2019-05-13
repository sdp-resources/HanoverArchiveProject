import org.junit.Before;
import org.junit.Test;
import photoarchives.Photo;

import static junit.framework.TestCase.assertEquals;

public class PhotoTest {
  private Photo photo;

  @Before
  public void setUp() throws Exception {
    String source = "source";
    String title = "title";
    photo = new Photo(source, title);
  }

  @Test
  public void whenTitleIsEdited_ExpectNewPhotoTitle() throws Exception {
    String newTitle = "new title";
    photo.setTitle(newTitle);
    assertEquals(newTitle, photo.getTitle());
  }
}
