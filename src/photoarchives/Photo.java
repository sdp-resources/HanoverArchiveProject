package photoarchives;

public class Photo {
  private String source;
  private String id;
  private LabelSet labels;

  public Photo() {
    this.source = null;
    this.id = null;
    this.labels = new LabelSet();
  }

  public Photo(String source) {
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

  public void setID(String newID) { this.id = newID; }

  public LabelSet getLabels() {
    return labels;
  }

  public void addLabel(PhotoLabel.Kind kind, String value) {
    labels.add(new PhotoLabel(kind, value));
  }
}
