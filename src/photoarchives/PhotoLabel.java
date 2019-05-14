package photoarchives;

public class PhotoLabel implements PhotoLabelInterface {

  private presetlabel kind;
  private String value;

  public PhotoLabel(presetlabel kind, String value) {
    this.value = value;
    this.kind =  kind;
  }

  public PhotoLabel(){
    presetlabel p1 = presetlabel.empty;
    this.kind = p1;
    this.value = "";
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
