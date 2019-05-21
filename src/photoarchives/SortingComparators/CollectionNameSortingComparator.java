package photoarchives.SortingComparators;

import photoarchives.Photo;
import photoarchives.PhotoLabel;

import java.util.Comparator;

public class CollectionNameSortingComparator implements Comparator<Photo> {
  public int compare(Photo photo1, Photo photo2) {
    return photo1.getLabelValue(PhotoLabel.Kind.COLLECTION_NAME).compareTo(photo2.getLabelValue(PhotoLabel.Kind.COLLECTION_NAME));
  }
}
