package photoarchives;

import java.util.ArrayList;

public class Photo {

  private String source;
  private String id;
  private FieldSet fields;
  private String imageLocation;
  private static final String IMAGE_PREFIX = "image_";
  private ArrayList<Categories> categories;

  public Photo() {
    this.source = null;
    this.id = null;
    this.fields = new FieldSet();
    this.imageLocation = null;
    this.categories = new ArrayList<>();
  }

  public Photo(String source) {
    this.source = source;
    this.id = null;
    this.fields = new FieldSet();
    this.imageLocation = null;
    this.categories = new ArrayList<>();
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

  public void addCategory(Categories category){
    categories.add(category);
  }

  public String getTitle() {return getFieldValue(Field.Kind.TITLE);}

  public String getLocation() {return getFieldValue(Field.Kind.LOCATION);}

  public String getImgURL() {return "file://" + imageLocation;}

  public ArrayList getCategories(){
    return categories;
  }

  public int getCategoriesAmount(){
    return categories.size();
  }

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
