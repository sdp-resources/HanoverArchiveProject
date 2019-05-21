import org.junit.Before;
import org.junit.Test;
import photoarchives.FieldSet;
import photoarchives.PhotoField;

import java.util.Iterator;

import static org.junit.Assert.*;

public class FieldSetTest {

  private FieldSet fields;

  PhotoField field1;
  PhotoField field2;
  PhotoField field3;

  @Before
  public void setUp() throws Exception {
    fields = new FieldSet();
    field1 = new PhotoField(PhotoField.Kind.DATE, "1991");
    field2 = new PhotoField(PhotoField.Kind.DESCRIPTION, "Test Description");
    field3 = new PhotoField(PhotoField.Kind.SUBJECT, "CS");
  }

  @Test
  public void newSetIsEmpty() {
    assertTrue(fields.isEmpty());
  }

  @Test
  public void setOfSizeOneIsNotEmpty() {
    fields.add(field1);
    checkThatSetIsEmpty();
  }

  @Test
  public void setOfSizeThreeIsNotEmpty() {
    addThreeFieldsToSet();
    checkThatSetIsEmpty();
  }

  @Test
  public void setOfSizeZeroReturnsZero() {
    assertEquals(fields.size(), 0);
  }

  @Test
  public void setOfSizeOneReturnsOne() {
    fields.add(field1);
    assertEquals(fields.size(), 1);
  }

  @Test
  public void setOfSizeThreeReturnsThree() {
    addThreeFieldsToSet();
    assertEquals(fields.size(), 3);
  }

  @Test
  public void checkThatFieldRemoveWorksWithOneField() {
    fields.add(field1);
    fields.remove(PhotoField.Kind.DATE);
    assertTrue(fields.isEmpty());
  }

  @Test
  public void checkThatFieldRemoveWorksWithThreeFields() {
    addThreeFieldsToSet();
    fields.remove(PhotoField.Kind.DATE); fields.remove(PhotoField.Kind.DESCRIPTION); fields.remove(
          PhotoField.Kind.SUBJECT);
    assertTrue(fields.isEmpty());
  }

  @Test
  public void checkRemovingFieldFromMiddleOfSet() {
    addThreeFieldsToSet();
    fields.remove(PhotoField.Kind.DESCRIPTION);
    assertTrue(fields.size() == 2);
  }

  @Test
  public void checkRemovingFieldFromEndOfSet() {
    addThreeFieldsToSet();
    fields.remove(PhotoField.Kind.SUBJECT);
    assertTrue(fields.size() == 2);
  }

  @Test
  public void checkForSecondFieldInSet_ReturnsTrue() {
    fields.add(field1); fields.add(field2);
    assertTrue(fields.contains(PhotoField.Kind.DESCRIPTION));
  }

  @Test
  public void checkForFirstFieldInSet_ReturnsTrue() {
    fields.add(field1); fields.add(field2);
    assertTrue(fields.contains(PhotoField.Kind.DATE));
  }

  @Test
  public void checkForSpecificFieldInSet_ReturnsFalse() {
    fields.add(field1); fields.add(field2);
    assertFalse(fields.contains(PhotoField.Kind.SUBJECT));
  }

  @Test
  public void getFieldValue_OneFieldInSet() {
    fields.add(field1);
    assertEquals("1991", fields.getFieldValue(PhotoField.Kind.DATE));
  }

  @Test
  public void getFieldValue_ThreeFieldsInSet() {
    addThreeFieldsToSet();
    assertEquals("Test Description", fields.getFieldValue(PhotoField.Kind.DESCRIPTION));
  }

  @Test
  public void getFieldValue_FieldSetDoesntContainFieldKind() {
    addThreeFieldsToSet();
    assertEquals("~", fields.getFieldValue(PhotoField.Kind.TITLE));
  }

  @Test
  public void setFieldValueExpectFieldValueToChange() {
    fields.add(field1);
    fields.setFieldValue(PhotoField.Kind.DATE, "2000");
    assertEquals("2000", fields.getFieldValue(PhotoField.Kind.DATE));
  }

  @Test
  public void setFieldValueThreeFieldsChangeValueOfMiddle() {
    addThreeFieldsToSet();
    fields.setFieldValue(PhotoField.Kind.DESCRIPTION, "New Description");
    assertEquals("New Description", fields.getFieldValue(PhotoField.Kind.DESCRIPTION));
  }

  @Test
  public void iteratorIteratesThroughSetOfOne() {
    int acc = 0;
    fields.add(field1);
    Iterator<PhotoField> itr = fields.iterator();
    while(itr.hasNext()) {
      acc++;
      itr.next();
    }
    assertEquals(1, acc);
  }
  @Test
  public void iteratorIteratesThroughSetOfThree() {
    int acc = 0;
    addThreeFieldsToSet();
    Iterator<PhotoField> itr = fields.iterator();
    while(itr.hasNext()) {
      acc++;
      itr.next();
    }
    assertEquals(3, acc);
  }

  private void addThreeFieldsToSet() {
    fields.add(field1);
    fields.add(field2);
    fields.add(field3);
  }

  private void checkThatSetIsEmpty() {
    assertFalse(fields.isEmpty());
  }
}
