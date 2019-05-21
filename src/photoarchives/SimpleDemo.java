package photoarchives;

import java.util.Scanner;

public class SimpleDemo  {
  private String archiveDir;
  public PhotoArchive photoArchive;

  public SimpleDemo() {
    archiveDir = "assets/public/image_archive";
    photoArchive = new PhotoArchive("demo", archiveDir);
    photoArchive.initialize();
  }

  public void runDemo() {
    Photo demoPhoto = new Photo("demoPhoto");
    demoPhoto.setUploadedFrom("images/demoImage.jpg");
    photoArchive.addPhotoToArchive(demoPhoto);
    System.out.println("Our Archive has " + photoArchive.getPhotoList().getLength() + " photo!");
    printLabels(demoPhoto);
    // Keep demo running so archive files can be checked (ugly comment)
    //waitForEnter();
    addPhoto();
  }

  public void printLabels(Photo photo){
    photo.addField(PhotoField.Kind.LOCATION, "Hanover");
    photo.addField(PhotoField.Kind.TITLE, "Title");
    photo.addField(PhotoField.Kind.SUBJECT, "Sports");
    for (PhotoField label : photo.getFields()) {
      System.out.println(label.getKind() + ": " + label.getValue());
    }

  }

  private void waitForEnter() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("<enter> when finished");
    while (scanner.hasNextLine()) {

    }
  }

  public void addPhoto(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Next Photo: ");
    String photoLocation = scanner.next();
    while(!(photoLocation.equals("no"))){
      System.out.print("Next Photo: ");
      photoLocation = scanner.next();
    }
  }

  public static void main(String[] args){
    SimpleDemo demo = new SimpleDemo();
    demo.runDemo();
  }

}
