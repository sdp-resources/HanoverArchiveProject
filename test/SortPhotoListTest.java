import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import photoarchives.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SortPhotoListTest {
  PhotoList testPhotoList = new PhotoList();
  SortedPhotoList sortedPhotoList = new SortedPhotoList();

  @Before
  public void setup(){
    createStockPhotos();
  }

  @Test
  public void SortableList(){
    Photo photo1 = new Photo();
    photo1.addLabel(PhotoLabel.Kind.TITLE, "title");
    testPhotoList.addPhoto(photo1);
    assertTrue(sortedPhotoList.canSortList(testPhotoList));
  }
/*  @Ignore
  @Test
  public void canCompareLabels(){
    Photo photo1 = new Photo();
    photo1.addLabel(PhotoLabel.Kind.TITLE, "Celtics trash");
    Photo photo2 = new Photo();
    photo1.addLabel(PhotoLabel.Kind.TITLE, "kyrie trash");
    testPhotoList.addPhoto(photo1);
    testPhotoList.addPhoto(photo2);
    assertEquals(photo1.getLabelValue(PhotoLabel.Kind.TITLE),
                 photo1.getLabelValue(PhotoLabel.Kind.TITLE.compareTo(photo2.getLabelValue(
                       PhotoLabel.Kind.TITLE))));
  }*/

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

