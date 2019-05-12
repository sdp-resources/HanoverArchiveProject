package voting;

import java.util.HashMap;
import java.util.Map;

public class Request {
  public final RequestType type;
  public final Map<String, String> params;

  public Request(RequestType type, Map<String, String> params) {
    this.type = type;
    this.params = params;
  }

  public static Request login(String username, String password) {
    Map<String, String> params = new HashMap<>();
    params.put("username", username);
    params.put("password", password);
    return new Request(RequestType.TYPE_LOGIN, params);
  }

  public enum RequestType {
    TYPE_LOGIN
  }
}
