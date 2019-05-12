package voting;

public interface Handler {
  boolean canHandle(Request request);
  Response handle(Request request);
}
