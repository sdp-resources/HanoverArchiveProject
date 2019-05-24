import org.junit.Before;
import org.junit.Test;
import photoarchives.*;

import java.io.File;

import static junit.framework.TestCase.*;

public class PhotoTests {
  private Photo photo;
  private String photoSource = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/John_Finley_Crowe.jpg/506px-John_Finley_Crowe.jpg";

  @Before
  public void setUp() {
    photo = new Photo();
  }

  @Test
  public void whenDefaultPhotoIsCreated_onlyIdIsSet() {
    Photo defaultPhoto = new Photo();
    assertNotNull(defaultPhoto.getID());
    assertNull(defaultPhoto.getRetrievedFromURL());
    assertEquals(0, defaultPhoto.getFields().size());
    assertEquals(0, defaultPhoto.getCategories().size());
  }

  @Test
  public void whenBuildImagePathIsCalled_itReturnsTheCorrectPath() {
    String testId = "12345";
    String testImageDir = "/tmp";
    String correctPath = "/tmp/image_12345.jpg";
    Photo testPhoto = new Photo(testId);
    assertEquals(correctPath, testPhoto.buildImagePath(testImageDir));
  }

  @Test
  public void whenPhotoIsCreatedFromImageURL_imageIsLoaded() {
    String imageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/John_Finley_Crowe.jpg/506px-John_Finley_Crowe.jpg";
    Photo photo = new Photo(imageURL, "/tmp");
    File imageFile = new File(photo.getImageFile());
    assertTrue(imageFile.exists());
    assertEquals(imageURL, photo.getRetrievedFromURL());
  }

  @Test
  public void getFieldValue_ReturnsCorrectValue() {
    photo.addField(Field.Kind.DATE, "1991");
    assertEquals("1991", photo.getFieldValue(Field.Kind.DATE));
  }

  @Test
  public void getFieldValue_ReturnsCorrectValueForMultipleFields() {
    photo.addField(Field.Kind.DATE, "1991");
    photo.addField(Field.Kind.DESCRIPTION, "Test Description");
    photo.addField(Field.Kind.SUBJECT, "CS");
    assertEquals("Test Description", photo.getFieldValue(Field.Kind.DESCRIPTION));
    assertEquals("CS", photo.getFieldValue(Field.Kind.SUBJECT));
    assertEquals("1991", photo.getFieldValue(Field.Kind.DATE));
  }

  @Test
  public void setFieldValue_ChangeDateField() {
    photo.addField(Field.Kind.DATE, "1991");
    photo.setFieldValue(Field.Kind.DATE, "2000");
    assertEquals("2000", photo.getFieldValue(Field.Kind.DATE));
  }

  @Test
  public void setFieldValue_ChangeFieldFromSetOfThree() {
    photo.addField(Field.Kind.DATE, "1991");
    photo.addField(Field.Kind.DESCRIPTION, "Test Description");
    photo.addField(Field.Kind.SUBJECT, "CS");
    photo.setFieldValue(Field.Kind.DESCRIPTION, "New Description");
    assertEquals("New Description", photo.getFieldValue(Field.Kind.DESCRIPTION));
  }

  @Test
  public void hasField_ReturnsTrueFromSetOfThree() {
    photo.addField(Field.Kind.DATE, "1991");
    photo.addField(Field.Kind.DESCRIPTION, "Test Description");
    photo.addField(Field.Kind.SUBJECT, "CS");
    assertTrue(photo.hasField(Field.Kind.DESCRIPTION));
  }

  @Test
  public void hasField_ReturnsFalseFromSetOfThree() {
    photo.addField(Field.Kind.DATE, "1991");
    photo.addField(Field.Kind.DESCRIPTION,"Test Description");
    photo.addField(Field.Kind.SUBJECT, "CS");
    assertFalse(photo.hasField(Field.Kind.TITLE));
  }

  @Test
  public void addCategoryTests() {
    photo.addCategory(Categories.BUILDING);
    assertEquals(1, photo.getCategoriesAmount());
  }

  @Test
  public void getCategoriesAmountTests() {
    photo.getCategories();
    assertEquals(0, photo.getCategoriesAmount());
  }

  @Test
  public void getCategoriesTests(){
    photo.addCategory(Categories.BUILDING);
    photo.addCategory(Categories.CLASSROOM);
    Categories cat = (Categories) photo.getCategories().get(0);
    assertEquals("Building", cat.getName());
  }

  @Test
  public void testGetImageFilename() {
    String imageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/John_Finley_Crowe.jpg/506px-John_Finley_Crowe.jpg";
    String imageDir = "/tmp";
    Photo photo = new Photo(imageURL, imageDir);
    String imageName = Photo.IMAGE_PREFIX + photo.getID() + "." + Photo.FORMAT;
    assertEquals(imageName, photo.getImageFilename());
  }
}
