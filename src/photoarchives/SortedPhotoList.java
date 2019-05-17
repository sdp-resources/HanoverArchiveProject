package photoarchives;
import java.util.*;

public class SortedPhotoList extends PhotoList{

  public boolean canSortList(PhotoList photos) {
    return photos.getLength() > 1;
  }

  public PhotoLabel compareTo(Photo photo1, Photo photo2){
    return photo1.getLabels().compareTo(photo2.getLabels());
  }
}
