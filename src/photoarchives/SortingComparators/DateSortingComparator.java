package photoarchives.SortingComparators;

import photoarchives.Photo;
import photoarchives.Field;

import java.util.Comparator;

public class DateSortingComparator implements Comparator<Photo> {
  public int compare(Photo photo1, Photo photo2) {
    return photo1.getFieldValue(Field.Kind.DATE).compareTo(photo2.getFieldValue(Field.Kind.DATE));
  }
}
