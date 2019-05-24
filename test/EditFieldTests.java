import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import photoarchives.Field;
import photoarchives.StringFieldValue;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EditFieldTests {

  private Field field;

  @Before
  public void setUp() {
    field = new Field();
  }

  @Test
  public void TestGetName() {
    field.setKind(Field.Kind.DATE);
    assertThat(field.getKind(), is(Field.Kind.DATE));
    assertThat(field.getKind().getName(), is("Date"));
  }

  @Test
  public void changeFieldValue_ExpectChange() {
    field.setValue("this");
    assertThat(field.getValue(), is("this"));
  }

  @Test
  public void canCreateEmptyField_ExpectEmptyStringAndNONEField(){
    Field newField = new Field();
    assertNull(newField.getValue());
    assertThat(newField.getKind(), is(Field.Kind.NONE));
  }

  @Test
  public void canCreateField_GivenKindValuePair(){
    Field newField = new Field(Field.Kind.DATE, "1999");
    assertThat(newField.getValue(), is("1999"));
    assertThat(newField.getKind(), is (Field.Kind.DATE));
  }

  @Test
  public void testSetKindMethod_ExpectChange(){
    field.setKind(Field.Kind.LOCATION);
    assertEquals(Field.Kind.LOCATION, field.getKind());
  }
}
