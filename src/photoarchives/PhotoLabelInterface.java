package photoarchives;

public interface PhotoLabelInterface {
  enum presetLabel{
    building, year, location, subject, empty;
  }

  presetLabel getData();

  void setData (presetLabel data);
}
