package photoarchives;

public enum Categories {
  BUILDING("Building"),
  STUDENT("Student"),
  CLASSROOM("Classroom"),
  FACULTY("Faculty");

  private final String name;

  Categories(String category) { this.name = category; }

  public String getName() { return name; }
}
