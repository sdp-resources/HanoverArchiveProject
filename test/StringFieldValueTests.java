import org.junit.Before;
import org.junit.Test;
import photoarchives.*;

import static org.junit.Assert.*;

public class StringFieldValueTests {

  private StringFieldValue string;

  @Before
  public void setup(){
    string = new StringFieldValue();
  }
  @Test
  public void canCreateStringFieldValue(){
    assertNull(string.get());
  }

  @Test
  public void canChangeStringFieldValue(){
    string.add("this");
    assertEquals(string.get(), "this");
  }

  @Test
  public void canChangeToStringFieldValue(){
    assertEquals(string.toString(), string.get());
  }

}
