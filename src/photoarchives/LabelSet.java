package photoarchives;

import java.util.HashSet;
import java.util.Set;

public class LabelSet {
  private Set<PhotoLabel> labels = new HashSet<>();

  public boolean isEmpty() {
    return labels.isEmpty();
  }

  public void add(PhotoLabel label) {
    labels.add(label);
  }

  public int size() {
    return labels.size();
  }

  public void remove(PhotoLabel label) { labels.remove(label); }

  public boolean contains(PhotoLabel label) {
    return labels.contains(label);
  }

  //public PhotoLabel getLabel(PhotoLabel.Kind kind) {
    //return ;
  //}
}
