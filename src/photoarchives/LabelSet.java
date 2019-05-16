package photoarchives;

import java.util.HashSet;
import java.util.Iterator;
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

  public void remove(PhotoLabel.Kind kind) {
    for(PhotoLabel label : labels) {
      if(label.getKind() == kind) {
        labels.remove(label);
        break;
      }
    }
  }

  public boolean contains(PhotoLabel.Kind kind) {
    for(PhotoLabel label : labels) {
      if(label.getKind() == kind) {
        return true;
      }
    }
    return false;
  }

  public String getLabelValue(PhotoLabel.Kind kind) {
    for (PhotoLabel label : labels) {
      if (label.getKind() == kind) {
        return label.getValue();
      }
    }
    return "NO LABEL OF KIND " + kind;
  }

  public void setLabelValue(PhotoLabel.Kind kind, String newValue) {
    for (PhotoLabel label : labels) {
      if (label.getKind() == kind) {
        label.setValue(newValue);
      }
    }
  }

  public Iterator<PhotoLabel> iterator() {
    return labels.iterator();
  }
}
