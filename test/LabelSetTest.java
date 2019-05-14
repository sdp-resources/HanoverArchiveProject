import org.junit.Before;
import org.junit.Test;
import photoarchives.LabelSet;
import photoarchives.PhotoLabel;

import static org.junit.Assert.*;

public class LabelSetTest {

  private LabelSet labels;

  private void addLabelsForTests(int numberOfLabels) {
    while (numberOfLabels > 0) {
      labels.add(new PhotoLabel("year", "199" + numberOfLabels));
      numberOfLabels--;
    }
  }

  @Before
  public void setUp() throws Exception {
    labels = new LabelSet();
  }

  @Test
  public void newSetIsEmpty() {
    assertTrue(labels.isEmpty());
  }

  @Test
  public void setOfSizeOneIsNotEmpty() {
    PhotoLabel label1 = new PhotoLabel("year", "1991"); labels.add(label1);
    assertFalse(labels.isEmpty());
  }

  @Test
  public void setOfSizeThreeIsNotEmpty() {
    PhotoLabel label1 = new PhotoLabel("year", "1991"); labels.add(label1);
    PhotoLabel label2 = new PhotoLabel("year", "1997"); labels.add(label2);
    PhotoLabel label3 = new PhotoLabel("year", "1990"); labels.add(label3);
    assertFalse(labels.isEmpty());
  }

  @Test
  public void setOfSizeZeroReturnsZero() {
    assertEquals(labels.size(), 0);
  }

  @Test
  public void setOfSizeOneReturnsOne() {
    PhotoLabel label1 = new PhotoLabel("year", "1991"); labels.add(label1);
    assertEquals(labels.size(), 1);
  }

  @Test
  public void setOfSizeThreeReturnsThree() {
    PhotoLabel label1 = new PhotoLabel("year", "1991"); labels.add(label1);
    PhotoLabel label2 = new PhotoLabel("year", "1997"); labels.add(label2);
    PhotoLabel label3 = new PhotoLabel("year", "1990"); labels.add(label3);
    assertEquals(labels.size(), 3);
  }

  @Test
  public void checkThatLabelRemoveWorksWithOneLabel() {
    PhotoLabel label1 = new PhotoLabel("year", "1991");
    labels.remove(label1);
    assertTrue(labels.isEmpty());
  }

  @Test
  public void checkThatLabelRemoveWorksWithThreeLabels() {
    PhotoLabel label1 = new PhotoLabel("year", "1991"); labels.add(label1);
    PhotoLabel label2 = new PhotoLabel("year", "1997"); labels.add(label2);
    PhotoLabel label3 = new PhotoLabel("year", "1990"); labels.add(label3);
    labels.remove(label1); labels.remove(label2); labels.remove(label3);
    assertTrue(labels.isEmpty());
  }

  @Test
  public void checkRemovingLabelFromMiddleOfSet() {
    PhotoLabel label1 = new PhotoLabel("year", "1991"); labels.add(label1);
    PhotoLabel label2 = new PhotoLabel("year", "1997"); labels.add(label2);
    PhotoLabel label3 = new PhotoLabel("year", "1990"); labels.add(label3);
    labels.remove(label2);
    assertTrue(labels.size() == 2);
  }

  @Test
  public void checkRemovingLabelFromEndOfSet() {
    PhotoLabel label1 = new PhotoLabel("year", "1991"); labels.add(label1);
    PhotoLabel label2 = new PhotoLabel("year", "1997"); labels.add(label2);
    PhotoLabel label3 = new PhotoLabel("year", "1990"); labels.add(label3);
    labels.remove(label3);
    assertTrue(labels.size() == 2);
  }

  @Test
  public void checkForSpecificLabelInSet() {
    PhotoLabel label1 = new PhotoLabel("year", "1991"); labels.add(label1);
    PhotoLabel label2 = new PhotoLabel("year", "1997"); labels.add(label2);
    assertTrue(labels.contains(label2));
  }

  @Test
  public void checkThatGetLabelWorks() {
    PhotoLabel label1 = new PhotoLabel("year", "1991"); labels.add(label1);
    assertEquals(labels.getLabel(label1), label1);
  }
}
