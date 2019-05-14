import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoArchive;
import photoarchives.PhotoList;

import static junit.framework.TestCase.assertEquals;

public class PhotoArchiveTest {
  private PhotoList photo;
  PhotoArchive photoArchive = new PhotoArchive("dog", photo);
  private Photo blankPhoto = new Photo();
  @Test
  public void PhotoArchiveKnowsNameTest() {
    assertEquals("dog", photoArchive.getName());
    assertEquals(photo, photoArchive.getPhotoList());
  }
  @Test
  public void ChangeNameOfPhotoArchive() {
    photoArchive.setName("cat");
    assertEquals("cat", photoArchive.getName());
  }
  @Test
  public void addPhotoToPhotoArchivePhotoList() {
    photoArchive.addPhotoToArchive(blankPhoto);
    assertEquals(1, photoArchive.getPhotoList().getLength());
  }
}

