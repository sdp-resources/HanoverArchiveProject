package photoarchives;

public class PhotoLabel implements PhotoLabelInterface {

  private String kind;
  private String value;

  public PhotoLabel(String kind, String value) {
    this.value = value;
    this.kind =  kind;
  }

  public PhotoLabel(){
    this.kind = "";
    this.value = "";
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }
}
