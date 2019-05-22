package photoarchives.SortingComparators;

import photoarchives.Photo;
import photoarchives.Field;

import java.util.Comparator;

public class HanoverSubjectSortingComparator implements Comparator<Photo> {
  public int compare(Photo photo1, Photo photo2) {
    return photo1.getFieldValue(Field.Kind.HANOVER_SUBJECT).compareTo(photo2.getFieldValue(
          Field.Kind.HANOVER_SUBJECT));
  }
}
