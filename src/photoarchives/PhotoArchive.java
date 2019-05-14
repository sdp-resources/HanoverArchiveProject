package photoarchives;
import photoarchives.PhotoList;

public class PhotoArchive {
  private String name;
  private PhotoList photos;
  public PhotoArchive(String name, PhotoList photos){
    this.name = name;
    this.photos = photos;
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
}
