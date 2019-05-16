package photoarchives;

import java.io.File;

public class Photo {
  private String uploadedFrom;
  private String id;
  private LabelSet labels;
  private String imageLocation;

  public Photo() {
    this.uploadedFrom = null;
    this.id = null;
    this.labels = new LabelSet();
    this.imageLocation = null;
  }

  public Photo(String source) {
    this.uploadedFrom = source;
    this.id = null;
    this.labels = new LabelSet();
    this.imageLocation = null;
  }

  public String getUploadedFrom() {
    return this.uploadedFrom;
  }

  public String getID() {
    return this.id;
  }

  public void setUploadedFrom(String s) {
    this.uploadedFrom = s;
  }

  public void setID(String newID) { this.id = newID; }

  public LabelSet getLabels() {
    return labels;
  }

  public void setImageLocation(String archiveLocation) {
    this.imageLocation = archiveLocation + "/" + "id" + ".jpeg";
  }

  public void addLabel(PhotoLabel.Kind kind, String value) {
    labels.add(new PhotoLabel(kind, value));
  }

  public String getImageLocation() {
    return imageLocation;
  }
}
