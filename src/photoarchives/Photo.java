package photoarchives;

public class Photo {
  private String source;
  private String title;

  public Photo(String source, String title) {
    this.source = source;
    this.title = title;
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
}
