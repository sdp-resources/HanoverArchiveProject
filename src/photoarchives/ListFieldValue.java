package photoarchives;

import java.util.ArrayList;

public class ListFieldValue implements FieldValueInterface {
  private ArrayList list;

  public ListFieldValue() {
    list = new ArrayList();
  }
  public void add(String string) {
    list.add(string);
  }

  public String get() {
    return this.toString();
  }

  @Override
  public String toString() {
    String str = "";
    for (int i = 0; i < list.size(); i++) {
      str += list.get(i) + " ";
    }
    return str;
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
}
