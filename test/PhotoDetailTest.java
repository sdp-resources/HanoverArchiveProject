import org.junit.Test;
import photoarchives.PhotoDetails;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhotoDetailTest {

  @Test
  public void canCreateDetails_createsEmptyList() {
    PhotoDetails details = new PhotoDetails();
    assertTrue(details.isEmpty());
  }
}
