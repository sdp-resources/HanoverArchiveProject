package photoarchives;

public class PhotoLabel implements PhotoLabelInterface {

  private String data;


  public PhotoLabel(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
