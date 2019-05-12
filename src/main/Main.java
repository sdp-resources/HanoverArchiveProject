package main;

import voting.Authorizer;
import voting.Handler;
import voting.SimpleRoutingHandler;

public class Main {

  private static Handler handler = null;
  private static Authorizer authorizer;

  public static Handler getHandler() {
    if (handler == null) {
      setupStandardHandler();
    }
    return handler;
  }

  private static void setupStandardHandler() {
    SimpleRoutingHandler handler = new SimpleRoutingHandler();
    // TODO: Add handlers here
    Main.handler = handler;
  }

  public static void setHandler(Handler handler) {
    Main.handler = handler;
  }

  public static void setAuthorizer(Authorizer authorizer) {
    Main.authorizer = authorizer;
  }

  public static Authorizer getAuthorizer() {
    return authorizer;
  }
}
