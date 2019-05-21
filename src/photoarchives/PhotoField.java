package photoarchives;

public class PhotoField {

  private Kind kind;
  private String value;

  public PhotoField(Kind kind, String value) {
    this.value = value;
    this.kind =  kind;
  }

  public PhotoField(){
    this.kind = Kind.NONE;
    this.value = "";
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Kind getKind() {
    return kind;
  }

  public void setKind(Kind kind) {
    this.kind = kind;
  }

  public enum Kind {
    TITLE("Title"),
    DESCRIPTION("Description"),
    DATE("Date"),
    SUBJECT("Subject"),
    HANOVER_SUBJECT("Hanover Subject"),
    LOCATION("Location"),
    CREATOR("Creator"),
    OBJECT_NUMBER("Object Number"),
    COLLECTION_NAME("Collection Name"),
    COPYRIGHT("Copyright"),
    URL("URL"),
    NONE("None");

    private final String name;

    Kind(String kind) { this.name = kind; }

    public String getName() { return name; }

  }
}
