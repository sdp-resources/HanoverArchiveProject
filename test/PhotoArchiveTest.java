import org.junit.Before;
import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoArchive;
import photoarchives.PhotoList;
import java.util.UUID;

import static junit.framework.Assert.assertTrue;

import static junit.framework.TestCase.assertEquals;

public class PhotoArchiveTest {
  private PhotoList photos;
  PhotoArchive photoArchive = new PhotoArchive("dog", "");
  private Photo blankPhoto;

  @Before
  public void createInitialArchive() {
    blankPhoto = new Photo();
    photos = new PhotoList();
    String archiveDir = "/tmp/" + UUID.randomUUID().toString();
    photoArchive = new PhotoArchive("dog", archiveDir);


  }


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
  public void clearAllPhotosFromPhotoArchive(){
    Photo p1 = new Photo("test source1" );
    Photo p2 = new Photo("test source2") ;
    Photo p3 = new Photo("test source3");
    photos.addPhoto(p1);
    photos.addPhoto(p2);
    photos.addPhoto(p3);
    photoArchive.clear();
    assertEquals(0,photoArchive.getPhotoList().getLength());
  }

  @Test
  public void createPhotoArchive() {
    PhotoArchive archive = new PhotoArchive("dog", "/home/helmersj20/cs321/HanoverArchive/");
    String basicDirectory = archive.getDirectory();
    assertEquals("/home/helmersj20/cs321/HanoverArchive/", basicDirectory);
    archive.initialize();
  }
}

