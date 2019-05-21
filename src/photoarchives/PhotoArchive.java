package photoarchives;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.UUID;

public class PhotoArchive {
  private String name;
  private PhotoList photos;
  private File imagesDirectory;

  public PhotoArchive(String name, String directory){
    this.name = name;
    this.photos = new PhotoList();
    this.imagesDirectory = new File(directory);
  }

  public void initialize() {
    if (!imagesDirectory.exists())
    {
      imagesDirectory.mkdir();
    }
  }

  public String getName() { return name; }

  public PhotoList getPhotoList() { return photos; }
  public PhotoList getPhotos() { return photos; }

  public String getArchivePath() { return imagesDirectory.getPath(); }

  public int getSize() {
    return getPhotoList().getLength();
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public void addPhoto(Photo newPhoto) {
    this.photos.addPhoto(newPhoto);
    newPhoto.setID(createUniqueIdForUploadedPhoto());
    try {
      BufferedImage image = loadImageFromSource(newPhoto);
      newPhoto.setImageLocation(imagesDirectory.getPath());
      File imageInArchive = new File(newPhoto.getImageLocation());
      ImageIO.write(image, "jpeg", imageInArchive);
    } catch (IOException e) {
    }
  }

  public void addPhoto(String url) {
    Photo newPhoto = new Photo(url);
    addPhoto(newPhoto);
  }

  private String createUniqueIdForUploadedPhoto() {
    return UUID.randomUUID().toString();
  }

  private BufferedImage loadImageFromSource(Photo newPhoto) throws IOException {
    return ImageIO.read(new URL(newPhoto.getSource()));
  }

  public void clear() {
    this.photos.clear();
  }
}
