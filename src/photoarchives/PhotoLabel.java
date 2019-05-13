package photoarchives;

public class PhotoLabel implements PhotoLabelInterface {

  private presetLabel data;

  public PhotoLabel(presetLabel data) {
    this.data = data;
  }

  public PhotoLabel(){
    presetLabel p1 = presetLabel.year;
    this.data = p1;
  }

  public presetLabel getData() {
    return data;
  }

  public void setData(presetLabel data) {
    this.data = data;
  }
}
