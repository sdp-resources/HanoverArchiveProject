package photoarchives.SortingComparators;

import photoarchives.Photo;
import photoarchives.PhotoLabel;

import java.util.Comparator;

public class DateSortingComparator implements Comparator<Photo> {
  public int compare(Photo photo1, Photo photo2) {
    return photo1.getLabelValue(PhotoLabel.Kind.DATE).compareTo(photo2.getLabelValue(PhotoLabel.Kind.DATE));
  }
}
