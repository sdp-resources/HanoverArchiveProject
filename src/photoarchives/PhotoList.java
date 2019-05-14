package photoarchives;

import java.util.ArrayList;
import java.util.Iterator;

public class PhotoList /*implements Iterable<Photo>*/ {
  ArrayList<Photo> photoList = new ArrayList<Photo>();

  public int getLength() {
    return photoList.size();
  }

  public void addPhoto(Photo photo) {
    photoList.add(photo);
  }

  public void removePhoto(Photo photo) {
    photoList.remove(photo);
  }

  public void clear() { photoList.clear(); }

}
