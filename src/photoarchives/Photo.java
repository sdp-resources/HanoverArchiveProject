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

  public void addField(Field.Kind kind, FieldValueInterface value) {
    fields.add(new Field(kind, value));
  }

  public boolean hasField(Field.Kind kind) {
    return fields.contains(kind);
  }

  public String getSource() {
    return this.source;
  }

  public String getID() {
    return this.id;
  }

  public FieldSet getFields() {
    return fields;
  }

  public String getFieldValue(Field.Kind kind) {
    return fields.getFieldValue(kind);
  }

  public String getImageLocation() {
    return imageLocation;
  }

  public String getTitle() {return getFieldValue(Field.Kind.TITLE);}

  public String getLocation() {return getFieldValue(Field.Kind.LOCATION);}

  public String getImgURL() {return "file://" + imageLocation;}

  public void setSource(String s) {
    this.source = s;
  }

  public void setID(String newID) { this.id = IMAGE_PREFIX + newID; }

  public void setFieldValue(Field.Kind kind, String newValue) {
    fields.setFieldValue(kind, newValue);
  }

  public void setImageLocation(String imageDir) {
    this.imageLocation = imageDir + "/" + id + ".jpeg";
  }

}
