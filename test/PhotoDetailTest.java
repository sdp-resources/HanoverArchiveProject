import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoDetails;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhotoDetailTest {


  @Test
  public void containsPhoto() {
    Photo photo = new Photo("dir", "PhotoName", "photoID");
    PhotoDetails photodetails = new PhotoDetails(photo);
    assertThat(photodetails.getPhoto(), is(photo));


  }
}
