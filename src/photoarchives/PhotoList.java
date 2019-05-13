package photoarchives;

import java.util.ArrayList;

public class PhotoList {
  ArrayList<Photo> photoList = new ArrayList<Photo>(); ;

  public int getLength() {
    return photoList.size();
  }

  public void addPhoto(Photo photo) {
    photoList.add(photo);
  }

  public void removePhoto(Photo photo) {
    photoList.remove(photo);
  }

  public ArrayList<String> printTitleList() {
    ArrayList<String> titleList = new ArrayList<String>();
    for (int i = 0; i < photoList.size(); i++)
    {
      titleList.add(photoList.get(i).getTitle());
    }
    return titleList;
  }
}
