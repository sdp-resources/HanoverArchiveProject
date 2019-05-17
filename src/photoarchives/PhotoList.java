package photoarchives;

import java.util.ArrayList;
import java.util.Iterator;

public class PhotoList implements Iterable<Photo>{
  private ArrayList<Photo> photoList;
  public  Iterator<Photo> PhotoListIterator;

  public PhotoList() { photoList = new ArrayList<Photo>();
  }

  public int getLength() { return photoList.size(); }

  public void addPhoto(Photo photo) { photoList.add(photo); }

  public void removePhoto(Photo photo) { photoList.remove(photo); }

  public void clear() { photoList.clear(); }

  public Photo get(int i) { return photoList.get(i); }

  public PhotoList search(PhotoLabel.Kind kind, String value) {
    PhotoList searchedList = new PhotoList();
    for (Photo photo : photoList)
    {
      if (hasMatchingLabelValue(photo, kind, value))
      {
          searchedList.addPhoto(photo);
      }
      else
      {
        continue;
      }
    }
    return searchedList;
  }

  private boolean hasMatchingLabelValue(Photo photo, PhotoLabel.Kind kind, String value) {
    return photo.hasLabel(kind) && photo.getLabelValue(kind) == value;
  }

  public Iterator<Photo> iterator() {
    PhotoListIterator = photoList.iterator();
    return PhotoListIterator;
  }

}

