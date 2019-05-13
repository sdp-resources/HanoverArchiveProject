import org.junit.Test;
import photoarchives.PhotoDetails;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhotoDetailTest {


  @Test
  public void canCreateDetails() {
    PhotoDetails details = new PhotoDetails();
  }
  @Test
  public void createsEmptyList() {
    PhotoDetails details = new PhotoDetails();
    assertThat(details.isEmpty(), is(true));
  }
}
