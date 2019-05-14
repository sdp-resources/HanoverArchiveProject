import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoArchive;
import photoarchives.PhotoList;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class PhotoArchiveTest {
  private PhotoList photos = new PhotoList();
  PhotoArchive photoArchive = new PhotoArchive("dog", "");
  private Photo blankPhoto = new Photo();

  @Test
  public void PhotoArchiveKnowsNameTest() {
    assertEquals("dog", photoArchive.getName());
   
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

  @Test
  public void createPhotoArchive() {
    PhotoArchive archive = new PhotoArchive("dog", "/home/helmersj20/cs321/HanoverArchive/");
    String basicDirectory = archive.getDirectory();
    assertEquals("/home/helmersj20/cs321/HanoverArchive/", basicDirectory);
    archive.initialize();

  }
}

