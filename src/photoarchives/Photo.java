package photoarchives;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class Photo {

  public static final String IMAGE_PREFIX = "image_";
  public static final String FORMAT = "jpg";
  private String id;
  private String retrievedFromURL;
  private String imageFile;
  private FieldSet fields;
  private ArrayList<Categories> categories;

  public Photo() {
    this.retrievedFromURL = null;
    this.id = generateID();
    this.fields = new FieldSet();
    this.imageFile = null;
    this.categories = new ArrayList<>();
  }

  public Photo(String sourceURL, String imageDir) {
    this();
    this.loadImage(sourceURL, imageDir);
  }

  public Photo(String id) {
    this();
    this.id = id;
  }

  private String generateID() {
    return UUID.randomUUID().toString();
  }

  public String getID() {
    return this.id;
  }

  public String buildImagePath(String imageDir) {
    return imageDir + "/" + IMAGE_PREFIX + id + "." + FORMAT;
  }

  public void loadImage(String sourceURL, String imageDir) {
    try {
      imageFile = buildImagePath(imageDir);
      BufferedImage image = retrieveImageFromURL(sourceURL);
      writeImageToFile(image);
      retrievedFromURL = sourceURL;
    } catch (IOException e) {
      System.out.println("Trouble Loading Photo: " + e.getMessage());
    }
  }

  private void writeImageToFile(BufferedImage image) throws IOException {
    FileImageOutputStream outFile = new FileImageOutputStream(new File(imageFile));
    ImageIO.write(image, FORMAT, outFile);
    outFile.close();
  }

  private BufferedImage retrieveImageFromURL(String sourceURL) throws IOException {
    BufferedImage image = null;
    try {
      image = ImageIO.read(new URL(sourceURL));
    }
    catch (Exception e) {
      System.out.println("IN retrieveImageFromURL: " + e.getMessage());
    }
    assert(image != null);
    return image;
  }

  public String getRetrievedFromURL() {
    return this.retrievedFromURL;
  }

  public String getImageFile() {
    return imageFile;
  }

  public void addField(Field.Kind kind, String value) {
    fields.add(new Field(kind, value));
  }

  public boolean hasField(Field.Kind kind) {
    return fields.contains(kind);
  }

  public FieldSet getFields() {
    return fields;
  }

  public String getFieldValue(Field.Kind kind) {
    return fields.getFieldValue(kind);
  }

  public void addCategory(Categories category){
    categories.add(category);
  }

  public String getTitle() {return getFieldValue(Field.Kind.TITLE);}

  public String getLocation() {return getFieldValue(Field.Kind.LOCATION);}

  public ArrayList getCategories(){
    return categories;
  }

  public int getCategoriesAmount(){
    return categories.size();
  }

  public void setFieldValue(Field.Kind kind, String newValue) {
    fields.setFieldValue(kind, newValue);
  }

  public String getImageFilename() {
    return (new File(imageFile)).getName();
  }
}
