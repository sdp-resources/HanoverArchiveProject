package voting;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleRoutingHandler implements Handler {
  private Collection<Handler> handlers = new ArrayList<>();

  public boolean canHandle(Request request) {
    for (Handler handler : handlers) {
      if (handler.canHandle(request)) {
        return true;
      }
    }
    return false;
  }

  public Response handle(Request request) {
    for (Handler handler : handlers) {
      if (handler.canHandle(request)) {
        return handler.handle(request);
      }
    }
    return Response.noKnownHandler(request);
  }

  public void addHandler(Handler handler) {
    this.handlers.add(handler);
  }

}
