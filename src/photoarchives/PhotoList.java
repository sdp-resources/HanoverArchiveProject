package photoarchives;
import java.util.*;

public class PhotoList implements Iterable<Photo>{
  private ArrayList<Photo> photoList;
  private  Iterator<Photo> PhotoListIterator;

  public PhotoList() {
    photoList = new ArrayList<>();
  }

  public Iterator<Photo> iterator() {
    PhotoListIterator = photoList.iterator();
    return PhotoListIterator;
  }

  public int getLength() { return photoList.size(); }

  public void addPhoto(Photo photo) { photoList.add(photo); }

  public void removePhoto(Photo photo) { photoList.remove(photo); }

  public void clear() { photoList.clear(); }

  public Photo get(int i) { return photoList.get(i); }

  public PhotoList search(PhotoField.Kind kind, StringFieldValue value) {
    PhotoList searchedList = new PhotoList();
    for (Photo photo : photoList)
    {
      if (hasMatchingFieldValue(photo, kind, value))
      {
          searchedList.addPhoto(photo);
      }
    }
    return searchedList;
  }

  private boolean hasMatchingFieldValue(Photo photo, PhotoField.Kind kind, StringFieldValue value) {
    return photo.hasField(kind) && photo.getFieldValue(kind).equals(value);
  }
  public void sort(Comparator SortingComparator){
    Collections.sort(photoList, SortingComparator);
  }
}

