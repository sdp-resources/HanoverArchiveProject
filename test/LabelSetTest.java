import org.junit.Before;
import org.junit.Test;
import photoarchives.LabelSet;
import photoarchives.PhotoLabel;

import java.util.Iterator;

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
    label2 = new PhotoLabel(PhotoLabel.Kind.DESCRIPTION, "Test Description");
    label3 = new PhotoLabel(PhotoLabel.Kind.SUBJECT, "CS");
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
    labels.remove(PhotoLabel.Kind.DATE);
    assertTrue(labels.isEmpty());
  }

  @Test
  public void checkThatLabelRemoveWorksWithThreeLabels() {
    addThreeLabelsToSet();
    labels.remove(PhotoLabel.Kind.DATE); labels.remove(PhotoLabel.Kind.DESCRIPTION); labels.remove(PhotoLabel.Kind.SUBJECT);
    assertTrue(labels.isEmpty());
  }

  @Test
  public void checkRemovingLabelFromMiddleOfSet() {
    addThreeLabelsToSet();
    labels.remove(PhotoLabel.Kind.DESCRIPTION);
    assertTrue(labels.size() == 2);
  }

  @Test
  public void checkRemovingLabelFromEndOfSet() {
    addThreeLabelsToSet();
    labels.remove(PhotoLabel.Kind.SUBJECT);
    assertTrue(labels.size() == 2);
  }

  @Test
  public void checkForSecondLabelInSetReturnsTrue() {
    labels.add(label1); labels.add(label2);
    assertTrue(labels.contains(PhotoLabel.Kind.DESCRIPTION));
  }

  @Test
  public void checkForFirstLabelInSetReturnsTrue() {
    labels.add(label1); labels.add(label2);
    assertTrue(labels.contains(PhotoLabel.Kind.DATE));
  }

  @Test
  public void checkForSpecificLabelInSetReturnsFalse() {
    labels.add(label1); labels.add(label2);
    assertFalse(labels.contains(PhotoLabel.Kind.SUBJECT));
  }

  @Test
  public void getLabelValueOneLabelInSet() {
    labels.add(label1);
    assertEquals("1991", labels.getLabelValue(PhotoLabel.Kind.DATE));
  }

  @Test
  public void getLabelValueThreeLabelsInSet() {
    addThreeLabelsToSet();
    assertEquals("Test Description", labels.getLabelValue(PhotoLabel.Kind.DESCRIPTION));
  }

  @Test
  public void getLabelValueLabelSetDoesntContainLabelKind() {
    addThreeLabelsToSet();
    assertEquals("~", labels.getLabelValue(PhotoLabel.Kind.TITLE));
  }

  @Test
  public void setLabelValueExpectLabelValueToChange() {
    labels.add(label1);
    labels.setLabelValue(PhotoLabel.Kind.DATE, "2000");
    assertEquals("2000", labels.getLabelValue(PhotoLabel.Kind.DATE));
  }

  @Test
  public void setLabelValueThreeLabelsChangeValueOfMiddle() {
    addThreeLabelsToSet();
    labels.setLabelValue(PhotoLabel.Kind.DESCRIPTION, "New Description");
    assertEquals("New Description", labels.getLabelValue(PhotoLabel.Kind.DESCRIPTION));
  }

  @Test
  public void iteratorIteratesThroughSetOfOne() {
    int acc = 0;
    labels.add(label1);
    Iterator<PhotoLabel> itr = labels.iterator();
    while(itr.hasNext()) {
      acc++;
      itr.next();
    }
    assertEquals(1, acc);
  }
  @Test
  public void iteratorIteratesThroughSetOfThree() {
    int acc = 0;
    addThreeLabelsToSet();
    Iterator<PhotoLabel> itr = labels.iterator();
    while(itr.hasNext()) {
      acc++;
      itr.next();
    }
    assertEquals(3, acc);
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
