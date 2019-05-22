package photoarchives;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FieldSet implements Iterable<Field>{
  private Set<Field> fields = new HashSet<>();

  public boolean isEmpty() {
    return fields.isEmpty();
  }

  public void add(Field field) {
    fields.add(field);
  }

  public int size() {
    return fields.size();
  }

  public void remove(Field.Kind kind) {
    for(Field field : fields) {
      if(hasMatchingKind(kind, field)) {
        fields.remove(field);
        break;
      }
    }
  }

  public boolean contains(Field.Kind kind) {
    for(Field field : fields) {
      if(hasMatchingKind(kind, field)) {
        return true;
      }
    }
    return false;
  }

  public String getFieldValue(Field.Kind kind) {
    for (Field field : fields) {
      if (hasMatchingKind(kind, field)) {
        return field.getValue();
      }
    }
    return "~";
  }

  public void setFieldValue(Field.Kind kind, String newValue) {
    for (Field field : fields) {
      if (hasMatchingKind(kind, field)) {
        field.setValue(newValue);
      }
    }
  }

  private boolean hasMatchingKind(Field.Kind kind, Field field) {
    return field.getKind() == kind;
  }

  public Iterator<Field> iterator() {
    return fields.iterator();
  }
}
