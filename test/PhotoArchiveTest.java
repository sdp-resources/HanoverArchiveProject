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
  private PhotoArchive photoArchive;
  private Photo blankPhoto;

  @Before
  public void createPhotoArchive() {
    blankPhoto = new Photo();
    photos = new PhotoList();
    String archiveDirectory = "/tmp/" + UUID.randomUUID().toString();
    photoArchive = new PhotoArchive("archiveName", archiveDirectory);
  }

  @After
  public void teardownArchive() {
    photoArchive.clear();
    File archiveDirectory = new File(photoArchive.getDirectory());
    if (archiveDirectory.exists())
    {
      archiveDirectory.delete();
    }
  }

 @Test
  public void PhotoArchiveKnowsNameTest() {
    assertEquals("archiveName", photoArchive.getName());
  }

  @Test
  public void ChangeNameOfPhotoArchive() {
    photoArchive.setName("archiveName");
    assertEquals("archiveName", photoArchive.getName());
  }

  @Test
  public void addPhotoToPhotoArchivePhotoList() {
    blankPhoto.setSource("testSource");
    photoArchive.addPhotoToArchive(blankPhoto);
    assertEquals(1, photoArchive.getPhotoList().getLength());
  }

  @Test
  public void clearAllPhotosFromPhotoArchive(){
    Photo photo1 = new Photo("test source1" );
    Photo photo2 = new Photo("test source2") ;
    Photo photo3 = new Photo("test source3");
    photos.addPhoto(photo1);
    photos.addPhoto(photo2);
    photos.addPhoto(photo3);
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

