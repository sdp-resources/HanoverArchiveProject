package photoarchives.SortingComparators;

import photoarchives.Photo;
import photoarchives.Field;

import java.util.Comparator;

public class SubjectSortingComparator implements Comparator<Photo> {
  public int compare(Photo photo1, Photo photo2) {
    return photo1.getFieldValue(Field.Kind.SUBJECT).compareTo(photo2.getFieldValue(Field.Kind.SUBJECT));
  }
}
