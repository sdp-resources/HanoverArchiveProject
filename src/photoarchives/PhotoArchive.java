package photoarchives;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

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

  public String getDirectory() { return this.directory; }

  public void setName(String newName) {
    this.name = newName;
  }

  public void addPhotoToArchive(Photo newPhoto) {
    this.photos.addPhoto(newPhoto);
    String uniqueID = createUniqueIdForUploadedPhoto();
    newPhoto.setID(uniqueID);
    writePhotoToArchiveDirectory(newPhoto, uniqueID);
  }

  public void clear() { this.photos.clear(); }

  public void initialize() {
    File theDirectory = new File(directory);
    if (!theDirectory.exists())
    {
      theDirectory.mkdir();
    }
  }

  private String createUniqueIdForUploadedPhoto() {
    return UUID.randomUUID().toString();
  }

  private void writePhotoToArchiveDirectory(Photo newPhoto, String uniqueID) {
    try {
      BufferedImage image = readImageObjectFromNewPhoto(newPhoto);
      File targetFile = createTargetFile(uniqueID);
      ImageIO.write(image, "jpeg", targetFile);
    } catch (IOException e) {
    }
  }

  private BufferedImage readImageObjectFromNewPhoto(Photo newPhoto) throws IOException {
    return ImageIO.read(new File(newPhoto.getSource()));
  }

  private File createTargetFile(String uniqueID) {
    return new File(directory + uniqueID);
  }
}
