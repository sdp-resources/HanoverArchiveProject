package photoarchives;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class PhotoUploader extends Photo {
  private Photo photo;

  public Photo uploadPhoto(String photoSource) {
    return new Photo(photoSource);
  }
}
