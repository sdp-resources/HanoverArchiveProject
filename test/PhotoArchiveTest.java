import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoArchive;
import photoarchives.PhotoList;

import static junit.framework.TestCase.assertEquals;

public class PhotoArchiveTest {
  private PhotoList photos = new PhotoList();
  PhotoArchive photoArchive = new PhotoArchive("dog", photos);
  private Photo blankPhoto = new Photo();

  @Test
  public void PhotoArchiveKnowsNameTest() {
    assertEquals("dog", photoArchive.getName());
    assertEquals(photos, photoArchive.getPhotoList());
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

