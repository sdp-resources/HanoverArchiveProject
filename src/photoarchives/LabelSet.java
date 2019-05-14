package photoarchives;

import java.util.HashSet;
import java.util.Set;

public class LabelSet {
  private Set<String> labels = new HashSet<>();
  public boolean isEmpty() {
    return labels.isEmpty();
  }

  public void add(String label) {
    labels.add(label);
  }

  public int size() {
    return labels.size();
  }

  public void remove(String label) {
    labels.remove(label);
  }

  public boolean contains(String label) {
    return labels.contains(label);
  }

  public String getLabel(String label1) {
    return label1;
  }
}
