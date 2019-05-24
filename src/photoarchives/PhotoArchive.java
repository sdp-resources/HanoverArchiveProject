package photoarchives;

import java.io.File;

public class PhotoArchive {
  private String name;
  private PhotoList photos;
  private File imagesDirectory;

  public PhotoArchive(String name, String directory){
    this.name = name;
    this.photos = new PhotoList();
    this.imagesDirectory = new File(directory);
  }

  public String getName() { return name; }

  public PhotoList getPhotoList() { return photos; }

  public String getArchivePath() { return imagesDirectory.getPath(); }

  public int getSize() {
    return getPhotoList().getLength();
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public void clear() {
    cleanDirectory();
    this.photos.clear();
  }

  private void cleanDirectory() {
    for(File file: imagesDirectory.listFiles())
      if (!file.isDirectory())
        file.delete();
  }

  public void addPhoto(Photo newPhoto) {
    //newPhoto.loadImage(imagesDirectory.getPath());
    this.photos.addPhoto(newPhoto);
  }

  public void initialize() {
    if (!imagesDirectory.exists())
    {
      imagesDirectory.mkdir();
    }
  }
}
