package photoarchives;

public interface PhotoLabelInterface {
  enum presetLabel{
    building, year, location, subject;
  }

  presetLabel getData();

  void setData (presetLabel data);
}
