package photoarchives;

public class PhotoLabel implements PhotoLabelInterface {

  private String value;

  public PhotoLabel(String data) {
    this.value = data;
  }

  public PhotoLabel(){
    String p1 = String.empty;
    this.value = p1;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
