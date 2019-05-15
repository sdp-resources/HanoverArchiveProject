import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoList;

import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PhotoListTests {
  private PhotoList photoList;
  private Photo photo;

  @Before
  public void setUp() {
    photoList = new PhotoList();
    photo = new Photo("test source");
  }

  @Test
  public void addOnePhoto_ExpectLengthToBeOne(){
    photoList.addPhoto(photo);
    assertEquals(photoList.getLength(), 1);

  }

  @Test
  public void removeOnePhoto_ExpectLengthToBeZero(){
    photoList.addPhoto(photo);
    photoList.removePhoto(photo);
    assertEquals(photoList.getLength(), 0);
  }

  @Test
  public void clearPhotoList() {
    addThreePhotosToList();
    photoList.clear();
    assertEquals(0, photoList.getLength());
  }

  @Test
  public void whenAddingThreePhotos_LengthUpdates(){
    addThreePhotosToList();
    assertEquals(photoList.getLength(),3);
  }


  @Test
  public void whenListIsEmpty_hasNextIsFalse(){
    Iterator<Photo> iter = photoList.iterator();
    assertFalse(iter.hasNext());
  }

  @Test
  public void whenListIsNotEmpty_hasNextIsTrue(){
    addThreePhotosToList();
    Iterator<Photo> iter = photoList.iterator();
    assertTrue(iter.hasNext());
  }

  @Test
  public void whenNextIsCalled_ReturnNextPhoto() {
    addThreePhotosToList();
    Iterator<Photo> iter = photoList.iterator();
    Photo test = iter.next();
    assertEquals("test source1", test.getSource());
  }

  @Test
  public void callNextTwice_ExpectSecondItemInList() {
    addThreePhotosToList();
    Iterator<Photo> iter = photoList.iterator();
    Photo first = iter.next();
    Photo second = iter.next();
    assertEquals("test source2", second.getSource());
  }

  public void addThreePhotosToList() {
    Photo p1 = new Photo("test source1" );
    Photo p2 = new Photo("test source2") ;
    Photo p3 = new Photo("test source3");
    photoList.addPhoto(p1);
    photoList.addPhoto(p2);
    photoList.addPhoto(p3);
  }



}
