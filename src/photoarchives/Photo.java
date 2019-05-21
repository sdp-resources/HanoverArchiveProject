package photoarchives;

public class Photo {

  private String uploadedFrom;
  private String id;
  private FieldSet fields;
  private String imageLocation;
  private static String imagePrefix = "image_";

  public Photo() {
    this.uploadedFrom = null;
    this.id = null;
    this.fields = new FieldSet();
    this.imageLocation = null;
  }

  public Photo(String source) {
    this.uploadedFrom = source;
    this.id = null;
    this.fields = new FieldSet();
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

  public FieldSet getFields() {
    return fields;
  }

  public void setImageLocation(String imageDir) {
    this.imageLocation = imageDir + "/" + id + ".jpeg";
  }

  public void addField(PhotoField.Kind kind, String value) {
    fields.add(new PhotoField(kind, value));
  }

  public String getImageLocation() {
    return imageLocation;
  }

  public String getFieldValue(PhotoField.Kind kind) {
    return fields.getFieldValue(kind);
  }

  public void setFieldValue(PhotoField.Kind kind, String newValue) {
    fields.setFieldValue(kind, newValue);
  }

  public boolean hasField(PhotoField.Kind kind) {
    return fields.contains(kind);
  }

}
