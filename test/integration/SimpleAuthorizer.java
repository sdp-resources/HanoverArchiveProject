package integration;

import org.junit.Before;
import org.junit.Test;
import voting.Authorizer;
import voting.UserID;

public class SimpleAuthorizer implements Authorizer {
  public static final String USERNAME = "aUsername";
  public static final String PASSWORD = "aPassword";
  private static SimpleAuthorizer authorizer;

  private String username;
  private String password;
  private UserID userID;

  SimpleAuthorizer(String username, String password) {
    this.addCredentials(username, password);
  }

  public void addCredentials(String username, String password) {
    if (this.username != null) { return; }
    this.username = username;
    this.password = password;
    this.userID = new ValidUserID(username);
  }

  public static class ValidUserID implements UserID {
    private String username;

    public ValidUserID(String username) {
      this.username = username;
    }
  }

  @Before
  public void setUp() throws Exception {
    authorizer = new SimpleAuthorizer(USERNAME, PASSWORD);
  }

  @Test
  public void rejectsIncorrectUsername() {

  }
}
