package integration;

import main.Main;
import org.junit.Before;
import org.junit.Test;
import voting.*;

import static org.junit.Assert.assertEquals;
import static voting.Response.ResponseType.*;

public class LoginRespectsAuthorization {

  public static final String USERNAME = "skiadas";
  public static final String PASSWORD = "haris";
  public static final String WRONG_PASSWORD = "wrong";
  private static final String WRONG_USERNAME = "wilson";
  private Handler handler;

  @Before
  public void setUp() {
    Main.setAuthorizer(new SimpleAuthorizer(USERNAME, PASSWORD));
    handler = Main.getHandler();
  }

  @Test
  public void whenUsingIncorrectCredentials_receiveErrorMessage() {
    assertIsNotAuthorized(Request.login(USERNAME, WRONG_PASSWORD));
    assertIsNotAuthorized(Request.login(WRONG_USERNAME, PASSWORD));
  }

  @Test
  public void whenUsingCorrectCredentials_becomeAuthorizedWithSessionID() {
    assertIsAuthorized(Request.login(USERNAME, PASSWORD));
  }

  private void assertIsAuthorized(Request request) {
    Response response = handler.handle(request);
    assertEquals(AUTHORIZED, response.getType());
  }

  private void assertIsNotAuthorized(Request request) {
    Response actualResponse = handler.handle(request);
    assertEquals(UNAUTHORIZED, actualResponse.getType());
  }

}