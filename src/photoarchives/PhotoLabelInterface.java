package photoarchives;

public interface PhotoLabelInterface {
  enum String {
    building, year, location, subject, empty;
  }

  String getValue();

  void setValue(String value);
}
