package photoarchives;

public class Photo {
  private String source;
  private String id;

  public Photo() {
    this.source = null;
    this.id = null;
  }

  public Photo(String source ) {
    this.source = source;
    this.id = null;
  }


  public String getSource() {
    return this.source;
  }

  public String getID() {
    return this.id;
  }

  public void setSource(String s) {
    this.source = s;
  }


}
