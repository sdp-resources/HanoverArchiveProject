import org.junit.Test;
import photoarchives.PhotoArchive;
import photoarchives.PhotoList;

public class PhotoArchiveTest {
  private PhotoList photo;
  @Test
  public void CreatePhotoArchiveDirectoryTest(){
    PhotoArchive photoArchive = new PhotoArchive("dog",photo);
    AssertEquals(photoArchive.getName(), "dog");
  }
}
