package photoarchives;

public interface PhotoLabelInterface {
  enum presetLabel{
    building, year, location, subject;
  }

  String getData();

  void setData(String data);
}
