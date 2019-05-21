import org.junit.Before;
import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoField;

import static junit.framework.TestCase.*;

public class PhotoTest {
  private Photo photo;

  @Before
  public void setUp() {
    String source = "source";
    photo = new Photo(source);
  }

  @Test
  public void createDefaultImage() {
    Photo p1 = new Photo();
    assertEquals(null, p1.getSource());
    assertEquals(null, p1.getID());
    assertEquals(0, p1.getFields().size());
  }

  @Test
  public void createImageWithGivenSource() {
    assertEquals("source", photo.getSource());
    assertEquals(null, photo.getID());
  }


  @Test
  public void setNewSource_ExpectChange() {
   photo.setSource("/usr...");
   assertEquals("/usr...", photo.getSource());
  }

  @Test
  public void setNewID_ExpectChange() {
    String testID = "001";
    photo.setID(testID);
    String photoId = "image_" + testID;
    assertEquals(photoId, photo.getID());
  }

  @Test
  public void getFieldValue_ReturnsCorrectValue() {
    photo.addField(PhotoField.Kind.DATE, "1991");
    assertEquals("1991", photo.getFieldValue(PhotoField.Kind.DATE));
  }

  @Test
  public void getFieldValue_ReturnsCorrectValueForMultipleFields() {
    photo.addField(PhotoField.Kind.DATE, "1991");
    photo.addField(PhotoField.Kind.DESCRIPTION, "Test Description");
    photo.addField(PhotoField.Kind.SUBJECT, "CS");
    assertEquals("Test Description", photo.getFieldValue(PhotoField.Kind.DESCRIPTION));
    assertEquals("CS", photo.getFieldValue(PhotoField.Kind.SUBJECT));
    assertEquals("1991", photo.getFieldValue(PhotoField.Kind.DATE));
  }

  @Test
  public void setFieldValue_ChangeDateField() {
    photo.addField(PhotoField.Kind.DATE, "1991");
    photo.setFieldValue(PhotoField.Kind.DATE, "2000");
    assertEquals("2000", photo.getFieldValue(PhotoField.Kind.DATE));
  }

  @Test
  public void setFieldValue_ChangeFieldFromSetOfThree() {
    photo.addField(PhotoField.Kind.DATE, "1991");
    photo.addField(PhotoField.Kind.DESCRIPTION, "Test Description");
    photo.addField(PhotoField.Kind.SUBJECT, "CS");
    photo.setFieldValue(PhotoField.Kind.DESCRIPTION, "New Description");
    assertEquals("New Description", photo.getFieldValue(PhotoField.Kind.DESCRIPTION));
  }

  @Test
  public void hasField_ReturnsTrueFromSetOfThree() {
    photo.addField(PhotoField.Kind.DATE, "1991");
    photo.addField(PhotoField.Kind.DESCRIPTION, "Test Description");
    photo.addField(PhotoField.Kind.SUBJECT, "CS");
    assertTrue(photo.hasField(PhotoField.Kind.DESCRIPTION));
  }

  @Test
  public void hasField_ReturnsFalseFromSetOfThree() {
    photo.addField(PhotoField.Kind.DATE, "1991");
    photo.addField(PhotoField.Kind.DESCRIPTION, "Test Description");
    photo.addField(PhotoField.Kind.SUBJECT, "CS");
    assertFalse(photo.hasField(PhotoField.Kind.TITLE));
  }
}
