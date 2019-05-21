import org.junit.Before;
import org.junit.Test;
import photoarchives.PhotoLabel;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class EditLabelTests {

  private PhotoLabel label;

  @Before
  public void setUp() {
    label = new PhotoLabel();
  }

  @Test
  public void newLabelHasValue_EmptyString() {
    assertThat(label.getValue(), is(""));
  }

  @Test
  public void changeLabelValue_ExpectChange() {
    label.setValue("this");
    assertThat(label.getValue(), is("this"));
  }

  @Test
  public void canCreateEmptyLabel_ExpectEmptyStringAndNONELabel(){
    PhotoLabel newLabel = new PhotoLabel();
    assertThat(newLabel.getValue(), is(""));
    assertThat(newLabel.getKind(), is(PhotoLabel.Kind.NONE));
  }

  @Test
  public void canCreateLabel_GivenKindValuePair(){
    PhotoLabel newLabel = new PhotoLabel(PhotoLabel.Kind.DATE, "1999");
    assertThat(newLabel.getValue(), is("1999"));
    assertThat(newLabel.getKind(), is (PhotoLabel.Kind.DATE));
  }

  @Test
  public void testSetKindMethod_ExpectChange(){
    label.setKind(PhotoLabel.Kind.LOCATION);
    assertEquals(PhotoLabel.Kind.LOCATION, label.getKind());
  }
}
