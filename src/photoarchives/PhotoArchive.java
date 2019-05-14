package photoarchives;
import photoarchives.PhotoList;

import java.io.File;

public class PhotoArchive {
  private String name;
  private PhotoList photos;
  private String directory;

  public PhotoArchive(String name, String directory){
    this.name = name;
    this.photos = new PhotoList();
    this.directory = directory;
  }

  public String getName() {
    return this.name;
  }

  public PhotoList getPhotoList() {
    return this.photos;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public void addPhotoToArchive(Photo newPhoto) {
    this.photos.addPhoto(newPhoto);
  }

  public String getDirectory() {
    return this.directory;
  }

  public void initialize() {
    File theDir = new File(directory);
    if(!theDir.exists())
    {
      theDir.mkdir();
    }
  }


}
