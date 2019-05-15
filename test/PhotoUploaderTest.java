import org.junit.Before;
import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoUploader;

import static org.junit.Assert.assertEquals;

public class PhotoUploaderTest {
  private Photo photo;
  private PhotoUploader photoUploader;

  @Before
  public void createPhotoUploader () {
    photoUploader = new PhotoUploader();
  }

  @Test
  public void testUploadPhoto() {
    Photo uploadedPhoto = photoUploader.uploadPhoto("testSource");
    photo = new Photo("testSource");
    assertEquals(photo.getSource(), uploadedPhoto.getSource());
  }
}
