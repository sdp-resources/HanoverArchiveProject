package photoarchives;

public class StringLabel implements PhotoLabelInterface {
  private String value;

  public StringLabel(String string){
    value = string;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
