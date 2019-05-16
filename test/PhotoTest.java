import org.junit.Before;
import org.junit.Test;
import photoarchives.Photo;
import photoarchives.PhotoLabel;

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
    assertEquals(null, p1.getUploadedFrom());
    assertEquals(null, p1.getID());
    assertEquals(0, p1.getLabels().size());
  }

  @Test
  public void createImageWithGivenSource() {
    assertEquals("source", photo.getUploadedFrom());
    assertEquals(null, photo.getID());
  }


  @Test
  public void setNewSource_ExpectChange() {
   photo.setUploadedFrom("/usr...");
   assertEquals("/usr...", photo.getUploadedFrom());
  }

  @Test
  public void setNewID_ExpectChange() {
    String testID = "001";
    photo.setID(testID);
    assertEquals(testID, photo.getID());
  }

  @Test
  public void getLabelValue_ReturnsCorrectValue() {
    photo.addLabel(PhotoLabel.Kind.DATE, "1991");
    assertEquals("1991", photo.getLabelValue(PhotoLabel.Kind.DATE));
  }

  @Test
  public void getLabelValue_ReturnsCorrectValueForMultipleLabels() {
    photo.addLabel(PhotoLabel.Kind.DATE, "1991");
    photo.addLabel(PhotoLabel.Kind.DESCRIPTION, "Test Description");
    photo.addLabel(PhotoLabel.Kind.SUBJECT, "CS");
    assertEquals("Test Description", photo.getLabelValue(PhotoLabel.Kind.DESCRIPTION));
    assertEquals("CS", photo.getLabelValue(PhotoLabel.Kind.SUBJECT));
    assertEquals("1991", photo.getLabelValue(PhotoLabel.Kind.DATE));
  }

  @Test
  public void setLabelValue_ChangeDateLabel() {
    photo.addLabel(PhotoLabel.Kind.DATE, "1991");
    photo.setLabelValue(PhotoLabel.Kind.DATE, "2000");
    assertEquals("2000", photo.getLabelValue(PhotoLabel.Kind.DATE));
  }

  @Test
  public void setLabelValue_ChangeLabelFromSetOfThree() {
    photo.addLabel(PhotoLabel.Kind.DATE, "1991");
    photo.addLabel(PhotoLabel.Kind.DESCRIPTION, "Test Description");
    photo.addLabel(PhotoLabel.Kind.SUBJECT, "CS");
    photo.setLabelValue(PhotoLabel.Kind.DESCRIPTION, "New Description");
    assertEquals("New Description", photo.getLabelValue(PhotoLabel.Kind.DESCRIPTION));
  }

  @Test
  public void hasLabel_ReturnsTrueFromSetOfThree() {
    photo.addLabel(PhotoLabel.Kind.DATE, "1991");
    photo.addLabel(PhotoLabel.Kind.DESCRIPTION, "Test Description");
    photo.addLabel(PhotoLabel.Kind.SUBJECT, "CS");
    assertTrue(photo.hasLabel(PhotoLabel.Kind.DESCRIPTION));
  }

  @Test
  public void hasLabel_ReturnsFalseFromSetOfThree() {
    photo.addLabel(PhotoLabel.Kind.DATE, "1991");
    photo.addLabel(PhotoLabel.Kind.DESCRIPTION, "Test Description");
    photo.addLabel(PhotoLabel.Kind.SUBJECT, "CS");
    assertFalse(photo.hasLabel(PhotoLabel.Kind.TITLE));
  }

}
