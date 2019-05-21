package photoarchives.SortingComparators;

import photoarchives.Photo;
import photoarchives.PhotoField;

import java.util.Comparator;

public class LocationSortingComparator implements Comparator<Photo> {
  public int compare(Photo photo1, Photo photo2) {
    return photo1.getFieldValue(PhotoField.Kind.LOCATION).compareTo(photo2.getFieldValue(PhotoField.Kind.LOCATION));
  }
}
