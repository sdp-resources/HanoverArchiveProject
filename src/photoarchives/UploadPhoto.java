package photoarchives;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class UploadPhoto extends Photo {
  private Photo photo;


  public UploadPhoto(Photo photo){
    this.photo = photo;

  }

  public Photo getPhoto() {

    return this.photo;
  }
}
