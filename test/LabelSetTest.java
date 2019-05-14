import org.junit.Before;
import org.junit.Test;
import photoarchives.LabelSet;

import static org.junit.Assert.*;

public class LabelSetTest {

  private LabelSet labels;

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
    labels.add("label");
    assertFalse(labels.isEmpty());
  }
  @Test
  public void setOfSizeOneReturnsOne() {
    labels.add("label");
    assertEquals(labels.size(), 1);
  }
  @Test
  public void setOfSizeThreeReturnsThree() {
    labels.add("label");
    labels.add("label2");
    labels.add("label3");
    assertEquals(labels.size(), 3);
  }
  @Test
  public void checkThatLabelRemoveWorks() {
    labels.add("label");
    labels.remove("label");
    assertTrue(labels.isEmpty());
  }
  @Test
  public void checkForSpecificLabelInSet() {
    labels.add("label");
    labels.add("label2");
    assertTrue(labels.contains("label2"));
  }
}
