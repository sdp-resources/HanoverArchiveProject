package photoarchives;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FieldSet implements Iterable<PhotoField>{
  private Set<PhotoField> fields = new HashSet<>();

  public boolean isEmpty() {
    return fields.isEmpty();
  }

  public void add(PhotoField field) {
    fields.add(field);
  }

  public int size() {
    return fields.size();
  }

  public void remove(PhotoField.Kind kind) {
    for(PhotoField field : fields) {
      if(hasMatchingKind(kind, field)) {
        fields.remove(field);
        break;
      }
    }
  }

  public boolean contains(PhotoField.Kind kind) {
    for(PhotoField field : fields) {
      if(hasMatchingKind(kind, field)) {
        return true;
      }
    }
    return false;
  }

  public String getFieldValue(PhotoField.Kind kind) {
    for (PhotoField field : fields) {
      if (hasMatchingKind(kind, field)) {
        return field.getValue();
      }
    }
    return "~";
  }

  public void setFieldValue(PhotoField.Kind kind, String newValue) {
    for (PhotoField field : fields) {
      if (hasMatchingKind(kind, field)) {
        field.setValue(newValue);
      }
    }
  }

  private boolean hasMatchingKind(PhotoField.Kind kind, PhotoField field) {
    return field.getKind() == kind;
  }

  public Iterator<PhotoField> iterator() {
    return fields.iterator();
  }
}
