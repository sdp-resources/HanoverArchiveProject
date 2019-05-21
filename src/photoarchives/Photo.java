package photoarchives;

public class Photo {

  private String source;
  private String id;
  private FieldSet fields;
  private String imageLocation;
  private static final String IMAGE_PREFIX = "image_";

  public Photo() {
    this.source = null;
    this.id = null;
    this.fields = new FieldSet();
    this.imageLocation = null;
  }

  public Photo(String source) {
    this.source = source;
    this.id = null;
    this.fields = new FieldSet();
    this.imageLocation = null;
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

  public void setID(String newID) { this.id = IMAGE_PREFIX + newID; }

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

  public String getTitle() {return getFieldValue(PhotoField.Kind.TITLE);}

  public String getLocation() {return getFieldValue(PhotoField.Kind.LOCATION);}

  public String getImgURL() {return "file://" + imageLocation;}

}
