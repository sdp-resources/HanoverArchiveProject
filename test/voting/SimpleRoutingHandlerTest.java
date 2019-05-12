package voting;

import org.junit.Test;

import static org.junit.Assert.*;
import static voting.Response.ResponseType.*;

public class SimpleRoutingHandlerTest {
  @Test
  public void whenNoSuitableHandlersPresent_returnCannotProcessRequest() {
    SimpleRoutingHandler handler = new SimpleRoutingHandler();
    Request stubRequest = new Request(null, null);
    Response response = handler.handle(stubRequest);
    assertEquals(CANNOT_PROCESS, response.getType());
  }
}