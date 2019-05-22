import org.junit.Before;
import org.junit.Test;
import photoarchives.Photo;
import photoarchives.Field;
import photoarchives.StringFieldValue;

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
    photo.addField(Field.Kind.DATE, new StringFieldValue("1991"));
    assertEquals("1991", photo.getFieldValue(Field.Kind.DATE));
  }

  @Test
  public void getFieldValue_ReturnsCorrectValueForMultipleFields() {
    photo.addField(Field.Kind.DATE, new StringFieldValue("1991"));
    photo.addField(Field.Kind.DESCRIPTION, new StringFieldValue("Test Description"));
    photo.addField(Field.Kind.SUBJECT, new StringFieldValue("CS"));
    assertEquals("Test Description", photo.getFieldValue(Field.Kind.DESCRIPTION));
    assertEquals("CS", photo.getFieldValue(Field.Kind.SUBJECT));
    assertEquals("1991", photo.getFieldValue(Field.Kind.DATE));
  }

  @Test
  public void setFieldValue_ChangeDateField() {
    photo.addField(Field.Kind.DATE, new StringFieldValue("1991"));
    photo.setFieldValue(Field.Kind.DATE, "2000");
    assertEquals("2000", photo.getFieldValue(Field.Kind.DATE));
  }

  @Test
  public void setFieldValue_ChangeFieldFromSetOfThree() {
    photo.addField(Field.Kind.DATE, new StringFieldValue("1991"));
    photo.addField(Field.Kind.DESCRIPTION, new StringFieldValue("Test Description"));
    photo.addField(Field.Kind.SUBJECT, new StringFieldValue("CS"));
    photo.setFieldValue(Field.Kind.DESCRIPTION, "New Description");
    assertEquals("New Description", photo.getFieldValue(Field.Kind.DESCRIPTION));
  }

  @Test
  public void hasField_ReturnsTrueFromSetOfThree() {
    photo.addField(Field.Kind.DATE, new StringFieldValue("1991"));
    photo.addField(Field.Kind.DESCRIPTION, new StringFieldValue("Test Description"));
    photo.addField(Field.Kind.SUBJECT, new StringFieldValue("CS"));
    assertTrue(photo.hasField(Field.Kind.DESCRIPTION));
  }

  @Test
  public void hasField_ReturnsFalseFromSetOfThree() {
    photo.addField(Field.Kind.DATE, new StringFieldValue("1991"));
    photo.addField(Field.Kind.DESCRIPTION, new StringFieldValue("Test Description"));
    photo.addField(Field.Kind.SUBJECT, new StringFieldValue("CS"));
    assertFalse(photo.hasField(Field.Kind.TITLE));
  }
}
