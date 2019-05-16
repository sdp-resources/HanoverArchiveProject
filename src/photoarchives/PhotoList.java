package photoarchives;

import java.util.ArrayList;
import java.util.Iterator;

public class PhotoList implements Iterable<Photo>{
  private ArrayList<Photo> photoList;

  public PhotoList() { photoList = new ArrayList<Photo>();
  }

  public int getLength() { return photoList.size(); }

  public void addPhoto(Photo photo) { photoList.add(photo); }

  public void removePhoto(Photo photo) { photoList.remove(photo); }

  public void clear() { photoList.clear(); }

  public  Iterator<Photo> PhotoListIterator;

  public Iterator<Photo> iterator() {
    PhotoListIterator = photoList.iterator();
    return PhotoListIterator;
  }

  public class PhotoListIterator implements Iterator<Photo> {
    private int currentIndex;

    public PhotoListIterator(){
      this.currentIndex = 0;
    }

    @Override
    public boolean hasNext(){ return currentIndex < photoList.size() ? true : false; }

    @Override
    public Photo next() {
      Photo photo = photoList.get(currentIndex);
      currentIndex++;
      return photo;
    }
  }
}

