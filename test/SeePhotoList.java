import org.junit.Test;
import photoarchives.PhotoList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SeePhotoList {
  PhotoList photoList = new PhotoList();

  @Test
  public void hasPhotos() {
    assertEquals(photoList.length(), 0);
  }



}
