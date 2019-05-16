import org.junit.Before;
import org.junit.Test;
import photoarchives.LabelSet;
import photoarchives.PhotoLabel;

import static org.junit.Assert.*;

public class LabelSetTest {

  private LabelSet labels;

  PhotoLabel label1;
  PhotoLabel label2;
  PhotoLabel label3;

  @Before
  public void setUp() throws Exception {
    labels = new LabelSet();
    label1 = new PhotoLabel(PhotoLabel.Kind.DATE, "1991");
    label2 = new PhotoLabel(PhotoLabel.Kind.DATE, "1997");
    label3 = new PhotoLabel(PhotoLabel.Kind.DATE, "1990");
  }

  @Test
  public void newSetIsEmpty() {
    assertTrue(labels.isEmpty());
  }

  @Test
  public void setOfSizeOneIsNotEmpty() {
    labels.add(label1);
    checkThatSetIsEmpty();
  }

  @Test
  public void setOfSizeThreeIsNotEmpty() {
    addThreeLabelsToSet();
    checkThatSetIsEmpty();
  }

  @Test
  public void setOfSizeZeroReturnsZero() {
    assertEquals(labels.size(), 0);
  }

  @Test
  public void setOfSizeOneReturnsOne() {
    labels.add(label1);
    assertEquals(labels.size(), 1);
  }

  @Test
  public void setOfSizeThreeReturnsThree() {
    addThreeLabelsToSet();
    assertEquals(labels.size(), 3);
  }

  @Test
  public void checkThatLabelRemoveWorksWithOneLabel() {
    labels.add(label1);
    labels.remove(label1);
    assertTrue(labels.isEmpty());
  }

  @Test
  public void checkThatLabelRemoveWorksWithThreeLabels() {
    addThreeLabelsToSet();
    labels.remove(label1); labels.remove(label2); labels.remove(label3);
    assertTrue(labels.isEmpty());
  }

  @Test
  public void checkRemovingLabelFromMiddleOfSet() {
    addThreeLabelsToSet();
    labels.remove(label2);
    assertTrue(labels.size() == 2);
  }

  @Test
  public void checkRemovingLabelFromEndOfSet() {
    addThreeLabelsToSet();
    labels.remove(label3);
    assertTrue(labels.size() == 2);
  }

  @Test
  public void checkForSpecificLabelInSet() {
    labels.add(label1); labels.add(label2);
    assertTrue(labels.contains(label2));
  }

  @Test
  public void checkThatGetLabelWorks() {
    labels.add(label1);
    //assertEquals(labels.getLabel(label1), label1);
  }

  private void addThreeLabelsToSet() {
    labels.add(label1);
    labels.add(label2);
    labels.add(label3);
  }

  private void checkThatSetIsEmpty() {
    assertFalse(labels.isEmpty());
  }
}
