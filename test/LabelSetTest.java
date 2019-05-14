import org.junit.Before;
import org.junit.Test;
import photoarchives.LabelSet;

import static org.junit.Assert.*;

public class LabelSetTest {

  private LabelSet labels;

  private void addLabelsForTests(int numberOfLabels) {
    while (numberOfLabels > 0) {
      labels.add("label" + numberOfLabels);
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
    addLabelsForTests(1);
    assertFalse(labels.isEmpty());
  }
  @Test
  public void setOfSizeOneReturnsOne() {
    addLabelsForTests(1);
    assertEquals(labels.size(), 1);
  }
  @Test
  public void setOfSizeThreeReturnsThree() {
    addLabelsForTests(3);
    assertEquals(labels.size(), 3);
  }
  @Test
  public void checkThatLabelRemoveWorks() {
    addLabelsForTests(1);
    labels.remove("label1");
    assertTrue(labels.isEmpty());
  }
  @Test
  public void checkForSpecificLabelInSet() {
    addLabelsForTests(2);
    assertTrue(labels.contains("label2"));
  }
  @Test
  public void checkThatGetLabelWorks() {
    addLabelsForTests(1);
    assertEquals(labels.getLabel("label1"), "label1");
  }
}
