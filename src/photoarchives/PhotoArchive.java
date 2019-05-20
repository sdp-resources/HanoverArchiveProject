package photoarchives;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

public class PhotoArchive {
  private String name;
  private PhotoList photos;
  private File imagesDirectory;

  public PhotoArchive(String name, String directory){
    this.name = name;
    this.photos = new PhotoList();
    imagesDirectory = new File(directory);
  }

  public String getName() { return name; }

  public PhotoList getPhotoList() { return photos; }

  public String getArchivePath() { return imagesDirectory.getPath(); }

  public void setName(String newName) {
    this.name = newName;
  }

  public void addPhotoToArchive(Photo newPhoto) {
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

  public void clear() { this.photos.clear(); }

  public void initialize() {
    if (!imagesDirectory.exists())
    {
      imagesDirectory.mkdir();
    }
  }

  private String createUniqueIdForUploadedPhoto() {
    return UUID.randomUUID().toString();
  }

  private BufferedImage loadImageFromSource(Photo newPhoto) throws IOException {
    return ImageIO.read(new File(newPhoto.getUploadedFrom()));
  }

  public int getSize() {
    return getPhotoList().getLength();
  }
}
