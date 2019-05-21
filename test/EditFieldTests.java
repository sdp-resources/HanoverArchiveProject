import org.junit.Before;
import org.junit.Test;
import photoarchives.PhotoField;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class EditFieldTests {

  private PhotoField field;

  @Before
  public void setUp() {
    field = new PhotoField();
  }

  @Test
  public void TestGetName() {
    field.setKind(PhotoField.Kind.DATE);
    assertThat(field.getKind(), is(PhotoField.Kind.DATE));
    assertThat(field.getKind().getName(), is("Date"));
  }

  @Test
  public void newFieldHasValue_EmptyString() {
    assertThat(field.getValue(), is(""));
  }

  @Test
  public void changeFieldValue_ExpectChange() {
    field.setValue("this");
    assertThat(field.getValue(), is("this"));
  }

  @Test
  public void canCreateEmptyField_ExpectEmptyStringAndNONEField(){
    PhotoField newField = new PhotoField();
    assertThat(newField.getValue(), is(""));
    assertThat(newField.getKind(), is(PhotoField.Kind.NONE));
  }

  @Test
  public void canCreateField_GivenKindValuePair(){
    PhotoField newField = new PhotoField(PhotoField.Kind.DATE, "1999");
    assertThat(newField.getValue(), is("1999"));
    assertThat(newField.getKind(), is (PhotoField.Kind.DATE));
  }

  @Test
  public void testSetKindMethod_ExpectChange(){
    field.setKind(PhotoField.Kind.LOCATION);
    assertEquals(PhotoField.Kind.LOCATION, field.getKind());
  }
}
