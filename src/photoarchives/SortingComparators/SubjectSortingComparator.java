package photoarchives.SortingComparators;

import photoarchives.Photo;
import photoarchives.PhotoLabel;

import java.util.Comparator;

public class SubjectSortingComparator implements Comparator<Photo> {
  public int compare(Photo photo1, Photo photo2) {
    return photo1.getLabelValue(PhotoLabel.Kind.SUBJECT).compareTo(photo2.getLabelValue(PhotoLabel.Kind.SUBJECT));
  }
}
