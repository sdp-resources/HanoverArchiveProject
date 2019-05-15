import org.junit.Before;
import org.junit.Test;
import photoarchives.PhotoLabel;
import photoarchives.PhotoLabelInterface;

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
  public void holdsCorrectData() {
    assertThat(label.getValue(), is(""));
  }

  @Test
  public void changeLabelValue() {
    label.setValue("this");
    assertThat(label.getValue(), is("this"));
  }

  @Test
  public void TestEmptyLabelData(){
    PhotoLabel newLabel = new PhotoLabel();
    assertThat(newLabel.getValue(), is(""));
    assertThat(newLabel.getKind(), is(PhotoLabel.Kind.NONE));
  }

  @Test
  public void TestConstructor(){
    PhotoLabel newLabel = new PhotoLabel(PhotoLabel.Kind.DATE, "1999");
    assertThat(newLabel.getValue(), is("1999"));
    assertThat(newLabel.getKind(), is (PhotoLabel.Kind.DATE));
  }

  @Test
  public void TestKind(){
    label.setKind(PhotoLabel.Kind.LOCATION);
    assertEquals(PhotoLabel.Kind.LOCATION, label.getKind());
  }
}
