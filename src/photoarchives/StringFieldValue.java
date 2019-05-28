package photoarchives;

public class StringFieldValue extends FieldValue {

  private final Field.Kind kind;
  private  String value;

  public StringFieldValue(Field.Kind kind, String value) {
    this.kind = kind;
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String stringValue) {
    this.value = stringValue;
  }
}
