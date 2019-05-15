package photoarchives;

import java.util.ArrayList;
import java.util.Iterator;

public class PhotoList {
  ArrayList<Photo> photoList = new ArrayList<Photo>();

  public  Iterator<Photo> iterator(){
    return new PhotoListIterator();
  }

  public int getLength() {
    return photoList.size();
  }

  public void addPhoto(Photo photo) {
    photoList.add(photo);
  }

  public void removePhoto(Photo photo) {
    photoList.remove(photo);
  }

  public void clear() { photoList.clear(); }

  public class PhotoListIterator implements Iterator<Photo> {
    private int currentIndex;

    public PhotoListIterator(){
      this.currentIndex = 0;
    }

    @Override
    public boolean hasNext(){
      if (currentIndex < photoList.size()){
        return true;
      }
      else {return false;}
    }

    @Override
    public Photo next() {
      Photo photo = photoList.get(currentIndex);
      currentIndex++;
      return photo;
    }
  }
}

