package photoarchives;

import java.util.Scanner;

public class SimpleDemo  {
  public static final String ARCHIVE_NAME = "Hanover Photo Archive";
  public static final String IMAGE_DIR = "/tmp/image_archive";
  public static PhotoArchive photoArchive = new PhotoArchive(ARCHIVE_NAME, IMAGE_DIR);

  public void runDemo() {
    photoArchive.initialize();
    System.out.println(ARCHIVE_NAME + " created!");
    addPhotoFromUser();
    System.out.println("\nCurrent Archive:\n");
    printPhotoList();
    //System.out.println("Our Archive has " + photoArchive.getPhotoList().getLength() + " photo!");
    // Keep demo running so archive files can be checked (ugly comment)
    waitForEnter();
  }

  public void printLabels(Photo photo) {
    photo.addField(PhotoField.Kind.LOCATION, "Hanover");
    photo.addField(PhotoField.Kind.TITLE, "Title");
    photo.addField(PhotoField.Kind.SUBJECT, "Sports");
    for (PhotoField label : photo.getFields()) {
      System.out.println(label.getKind() + ": " + label.getValue());
    }
  }

  public void printPhotoList() {
    for (Photo photo : photoArchive.getPhotoList()) {
      System.out.print("photo id: " + photo.getID() + " ");
      System.out.print("title: " + photo.getFieldValue(PhotoField.Kind.TITLE) + " ");
      System.out.println("image location: " + photo.getImageLocation());
    }
  }

  private void waitForEnter() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("<enter> when finished");
    while (scanner.hasNextLine()) {

    }
  }

  public void addPhotoFromUser() {
    Scanner scanner = new Scanner(System.in);
    Photo photo = new Photo(getURL(scanner));
    photo.addField(PhotoField.Kind.TITLE, getTitle(scanner));
    photoArchive.addPhoto(photo);
  }

  public String getURL(Scanner scanner) {
    System.out.print("Photo URL? ");
    return scanner.next();
  }

  public String getTitle(Scanner scanner) {
    System.out.print("Photo Title? ");
    return scanner.next();
  }

  public static void main(String[] args){
    SimpleDemo demo = new SimpleDemo();
    demo.runDemo();
  }

}
