import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoList;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PhotoListTests {
  PhotoList photoList = new PhotoList();
  Photo photo = new Photo("test source", "test title");

  @Test
  public void hasPhotos() {
    assertEquals(photoList.getLength(), 0);
  }

  @Test
  public void addOnePhoto(){
    photoList.addPhoto(photo);
    assertEquals(photoList.getLength(), 1);

  }

  @Test
  public void removePhoto(){
    photoList.addPhoto(photo);
    photoList.removePhoto(photo);
    assertEquals(photoList.getLength(), 0);
  }

  @Test
  public void addThreePhotos(){
    addThreePhotosToList();
    assertEquals(photoList.getLength(),3);
  }

  @Test
  public void testPhotoListPrint(){
    addThreePhotos();
    ArrayList<String> Test = photoList.printTitleList();
    assertEquals("Students", Test.get(0));
    assertEquals("Faculty", Test.get(1));
    assertEquals("Athletics", Test.get(2));
  }


  private void addThreePhotosToList() {
    Photo p1 = new Photo("test source1", "Students");
    Photo p2 = new Photo("test source2", "Faculty");
    Photo p3 = new Photo("test source3", "Athletics");
    photoList.addPhoto(p1);
    photoList.addPhoto(p2);
    photoList.addPhoto(p3);
  }



}
