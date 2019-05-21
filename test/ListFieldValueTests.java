import org.junit.Before;
import org.junit.Test;
import photoarchives.*;

import static org.junit.Assert.*;
public class ListFieldValueTests {

  private ListFieldValue valueList;

  @Before
  public void setup(){
    valueList = new ListFieldValue();
  }

  @Test
  public void canCreateStringFieldValue(){
    assertTrue(valueList.isEmpty());
  }

  @Test
  public void canChangeStringFieldValue(){
    valueList.add("this");
    valueList.add("is");
    valueList.add("it");
    assertEquals("this is it", valueList.get());
  }

}
