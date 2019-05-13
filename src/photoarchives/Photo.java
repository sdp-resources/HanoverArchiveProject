package photoarchives;

public class Photo {
  private String source;
  private String title;
  private String id;

  public Photo(String source, String title, String id) {
    this.source = source;
    this.title = title;
    this.id = id;
  }

  public String getSource() {
    return this.source;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String newTitle) {
    this.title = newTitle;
  }

  public String getID() {
    return this.id;
  }
}
