package photoarchives;

import java.util.ArrayList;

public class PhotoList {
  int length = 0;
  ArrayList<Photo> photoList = new ArrayList<Photo>(length); ;

  public int getLength() {
    return length;
  }

  public void addPhoto(Photo photo) {
    photoList.add(photo);
    length++;
  }

  public void removePhoto(Photo photo) {
    photoList.remove(photo);
    length--;
  }
}
