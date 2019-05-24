import org.junit.*;
import photoarchives.*;

import java.io.File;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class PhotoArchiveTests {
  private static final String ARCHIVE_DIR = "assets/public/test_archive";
  private static final String ARCHIVE_NAME = "Test Archive";
  private final String url1 = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/John_Finley_Crowe.jpg/506px-John_Finley_Crowe.jpg";
  private final String url2 = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Crowe-Garritt_House_in_color.jpg/800px-Crowe-Garritt_House_in_color.jpg";
  private final String url3 = "https://upload.wikimedia.org/wikipedia/commons/1/1f/Hanover_College_Campus_Aerial.jpg";
  private Photo[] testPhotos = new Photo[10];
  private PhotoArchive photoArchive;

  @Before
  public void setUp() {
    photoArchive = new PhotoArchive(ARCHIVE_NAME, ARCHIVE_DIR);
    photoArchive.initialize();
    createTestPhotos();
  }

  private void createTestPhotos() {
    testPhotos[0] = new Photo(url1, "/tmp");
    testPhotos[1] = new Photo(url2, "/tmp");
    testPhotos[3] = new Photo(url3, "/tmp");
  }

  @After
  public void tearDown() {
    photoArchive.clear();
  }

  @Test
  public void whenFirstCreated_photoArchiveHasImageDirectory() {
    File imageDir = new File(photoArchive.getArchivePath());
    assertTrue(imageDir.exists());
  }

  @Test
  public void whenFirstCreated_PhotoArchiveIsEmpty(){
    photoArchive.initialize();
    assertEquals(0, photoArchive.getSize());
  }

  @Test
  public void whenCreated_photoArchiveCanSetAndGetName() {
    photoArchive.setName("archiveName");
    assertEquals("archiveName", photoArchive.getName());
  }

  @Test
  public void testPhotoArchive_addOnePhotoToArchive() {
    photoArchive.addPhoto(testPhotos[0]);
    File imageFile = new File(testPhotos[0].getImageFile());
    assertEquals(1, photoArchive.getSize());
    assertTrue(imageFile.exists());
  }

}

