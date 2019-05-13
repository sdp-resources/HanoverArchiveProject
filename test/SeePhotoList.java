import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SeePhotoList {
  PhotoList photoList = new PhotoList();
  Photo photo;

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



}
