package photoarchives;

public class PhotoUploader extends Photo {

  public Photo uploadPhoto(String photoSource) {
    return new Photo(photoSource);
  }
}
