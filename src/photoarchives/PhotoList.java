package photoarchives;
import java.util.*;

public class PhotoList implements Iterable<Photo>{
  private ArrayList<Photo> photoList;

  public PhotoList() {
    photoList = new ArrayList<>();
  }

  public Iterator<Photo> iterator() {
    return photoList.iterator();
  }

  public void addPhoto(Photo photo) { photoList.add(photo); }

  public void removePhoto(Photo photo) { photoList.remove(photo); }

  public void clear() { photoList.clear(); }

  public int getLength() { return photoList.size(); }

  public Photo get(int i) { return photoList.get(i); }

  public PhotoList search(Field.Kind kind, String value) {
    PhotoList searchedList = new PhotoList();
    for (Photo photo : photoList)
    {
      if (hasMatchingFieldValue(photo, kind, value))
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

  private boolean hasMatchingFieldValue(Photo photo, Field.Kind kind, String value) {
    return photo.hasField(kind) && photo.getFieldValue(kind).equals(value);
  }

  public void sort(Comparator SortingComparator){
    Collections.sort(photoList, SortingComparator);
  }

}

