package photoarchives;

import java.util.UUID;

public class SimpleDemo  {
  private String archiveDir;
  public PhotoArchive photoArchive;

  public SimpleDemo() {
    archiveDir = "/tmp/simpleArchive" + UUID.randomUUID().toString();
    photoArchive = new PhotoArchive("demo", archiveDir);
    photoArchive.initialize();
  }

  public void runDemo() {
    Photo demoPhoto = new Photo("demoPhoto");
    demoPhoto.setSource("images/demoImage.jpg");
    photoArchive.addPhotoToArchive(demoPhoto);
    System.out.println("Our Archive has " + photoArchive.getPhotoList().getLength() + " photo!");
  }

  public void printLabels(Photo photo){
    photo.addLabel(PhotoLabel.Kind.LOCATION, "Hanover");
    PhotoLabel label = photo.getLabels().getLabel("");
    System.out.println(label.getKind() + ": " + label.getValue());
  }

}
