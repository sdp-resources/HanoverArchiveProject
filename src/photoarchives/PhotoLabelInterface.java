package photoarchives;

public interface PhotoLabelInterface {
  enum presetlabel {
    building, year, location, subject, empty;
  }

  String getValue();

  void setValue(String value);
}
