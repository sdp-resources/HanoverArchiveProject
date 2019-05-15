import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoUploader;

import static org.junit.Assert.assertEquals;

public class PhotoUploaderTest {
  private Photo photo;
  private PhotoUploader photoUploader;

  @Test
  private void testUploadPhoto() {
    Photo uploadedPhoto = photoUploader.uploadPhoto("testSource");
    photo = new Photo("testSource");
    assertEquals(photo, uploadedPhoto);
  }
}
