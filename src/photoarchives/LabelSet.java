package photoarchives;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LabelSet implements Iterable<PhotoLabel>{
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

  public void remove(PhotoLabel.Kind kind) {
    for(PhotoLabel label : labels) {
      if(hasMatchingKind(kind, label)) {
        labels.remove(label);
        break;
      }
    }
  }

  public boolean contains(PhotoLabel.Kind kind) {
    for(PhotoLabel label : labels) {
      if(hasMatchingKind(kind, label)) {
        return true;
      }
    }
    return false;
  }

  public String getLabelValue(PhotoLabel.Kind kind) {
    for (PhotoLabel label : labels) {
      if (hasMatchingKind(kind, label)) {
        return label.getValue();
      }
    }
    return "~";
  }

  public void setLabelValue(PhotoLabel.Kind kind, String newValue) {
    for (PhotoLabel label : labels) {
      if (hasMatchingKind(kind, label)) {
        label.setValue(newValue);
      }
    }
  }

  private boolean hasMatchingKind(PhotoLabel.Kind kind, PhotoLabel label) {
    return label.getKind() == kind;
  }

  public Iterator<PhotoLabel> iterator() {
    return labels.iterator();
  }
}
