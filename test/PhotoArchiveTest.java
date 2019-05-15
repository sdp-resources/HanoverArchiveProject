import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import photoarchives.*;

import java.io.File;
import java.util.UUID;

import static junit.framework.Assert.assertTrue;

import static junit.framework.TestCase.assertEquals;

public class PhotoArchiveTest {
  private PhotoList photos;
  PhotoArchive photoArchive;
  private Photo blankPhoto;

  @Before
  public void createPhotoArchive() {
    blankPhoto = new Photo();
    photos = new PhotoList();
    String archiveDir = "/tmp/" + UUID.randomUUID().toString();
    photoArchive = new PhotoArchive("dog", archiveDir);
  }

  @After
  public void teardownArchive() {
    photoArchive.clear();
    File archiveDir = new File(photoArchive.getDirectory());
    if (archiveDir.exists())
    {
      archiveDir.delete();
    }
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
    blankPhoto.setSource("testSource");
    photoArchive.addPhotoToArchive(blankPhoto);
    System.out.println(photoArchive.getPhotoList().getLength());
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
    assertEquals(0, photoArchive.getPhotoList().getLength());
  }

  @Test
  public void whenInitialized_photoArchiveDirectoryIsCreated() {
    photoArchive.initialize();
    File archiveDir = new File(photoArchive.getDirectory());
    assertTrue(archiveDir.exists());
  }

  @Test
  public void testingUploadPhoto() {
    String imageLocation = "/home/helmersj20/cs321/HanoverArchiveProject/SampleArchive/Images";
    Photo examplePhoto = new Photo(imageLocation + "/download.jpeg");
    photoArchive.addPhotoToArchive(examplePhoto);

  }
}

