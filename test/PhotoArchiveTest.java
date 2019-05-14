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
  @Test
  public void clearallPhotosfromPhotoArchive(){
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
  public void canSetIds(){
    Photo p1 = new Photo("test source1");
    photoArchive.addPhotoToArchive(p1);
    assertEquals("cat", p1.getID());

  }
}

