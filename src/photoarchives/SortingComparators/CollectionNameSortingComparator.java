package photoarchives.SortingComparators;

import photoarchives.Photo;
import photoarchives.Field;

import java.util.Comparator;

public class CollectionNameSortingComparator implements Comparator<Photo> {
  public int compare(Photo photo1, Photo photo2) {
    return photo1.getFieldValue(Field.Kind.COLLECTION_NAME).compareTo(photo2.getFieldValue(
          Field.Kind.COLLECTION_NAME));
  }
}
