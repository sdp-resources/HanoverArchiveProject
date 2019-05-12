package voting;

import java.util.HashMap;
import java.util.Map;

public class Response {
  private ResponseType type;
  private Map<String, Object> data = new HashMap<>();

  public Response(ResponseType type) {
    this.type = type;
  }

  public static Response unauthorized() {
    return new Response(ResponseType.UNAUTHORIZED);
  }

  public static Response authorized() {
    return new Response(ResponseType.AUTHORIZED);
  }

  public static Response noKnownHandler(Request request) {
    Response response = new Response(ResponseType.CANNOT_PROCESS);
    response.data.put("request", request);
    return response;
  }

  public ResponseType getType() {
    return type;
  }

  public void setData(String key, String value) {
    data.put(key, value);
  }

  public Object getData(String key) {
    return data.get(key);
  }

  public enum ResponseType {
    AUTHORIZED, UNAUTHORIZED, CANNOT_PROCESS
  }
}
