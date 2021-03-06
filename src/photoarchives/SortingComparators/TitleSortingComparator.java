package photoarchives.SortingComparators;

import photoarchives.Photo;
import photoarchives.Field;

import java.util.Comparator;

public class TitleSortingComparator implements Comparator<Photo> {
  public int compare(Photo photo1, Photo photo2) {
    return photo1.getFieldValue(Field.Kind.TITLE).compareTo(photo2.getFieldValue(Field.Kind.TITLE));
  }
}

