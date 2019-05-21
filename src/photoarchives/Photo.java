package photoarchives;

import java.io.File;

public class Photo implements Comparable<Photo> {

  private String uploadedFrom;
  private String id;
  private LabelSet labels;
  private String imageLocation;
  private static String imagePrefix = "image_";

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

  public void setID(String newID) { this.id = imagePrefix + newID; }

  public LabelSet getLabels() {
    return labels;
  }

  public void setImageLocation(String imageDir) {
    this.imageLocation = imageDir + "/" + id + ".jpeg";
  }

  public void addLabel(PhotoLabel.Kind kind, String value) {
    labels.add(new PhotoLabel(kind, value));
  }

  public String getImageLocation() {
    return imageLocation;
  }

  public String getLabelValue(PhotoLabel.Kind kind) {
    return labels.getLabelValue(kind);
  }

  public void setLabelValue(PhotoLabel.Kind kind, String newValue) {
    labels.setLabelValue(kind, newValue);
  }

  public boolean hasLabel(PhotoLabel.Kind kind) {
    return labels.contains(kind);
  }

  @Override
  public int compareTo(Photo otherPhoto) {
    return this.getLabelValue(PhotoLabel.Kind.TITLE).compareTo(otherPhoto.getLabelValue(PhotoLabel.Kind.TITLE));
  }
}
