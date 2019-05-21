package photoarchives;

public class StringFieldValue implements FieldValueInterface {
  private String value = null;

  @Override
  public void add(String string) {
    this.value = string;
  }

  @Override
  public String get() {
    return value;
  }

  @Override
  public String toString(){
    return this.value;
  }
}
