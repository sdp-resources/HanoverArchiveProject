import org.junit.Before;
import org.junit.Test;
import photoarchives.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SortPhotoListTest {
  PhotoList testPhotoList = new PhotoList();

  @Before
  public void setup(){
    createStockPhotos();
  }

  @Test
  public void canCreateSortedPhotoList(){
    SortedPhotoList sortedPhotoList = new SortedPhotoList();


  }

  @Test
  public void emptySortedList(){
    for(Photo testPhoto : testPhotoList) {
      testPhoto.addLabel(PhotoLabel.Kind.TITLE, "title");
    }


  }

  @Test
  public void oneItemSortedList(){

  }

  @Test
  public void sortedPhotoList(){

  }



  private void createStockPhotos() {
    Photo photo1 = new Photo("test source1" );
    Photo photo2 = new Photo("test source2") ;
    Photo photo3 = new Photo("test source3");
    testPhotoList.addPhoto(photo1);
    testPhotoList.addPhoto(photo2);
    testPhotoList.addPhoto(photo3);
  }
}

