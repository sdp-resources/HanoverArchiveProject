package photoarchives;

import java.util.Scanner;

public class SimpleDemo  {
  public static final String ARCHIVE_NAME = "Hanover Photo Archive";
  public static final String IMAGE_DIR = "assets/public/image_archive";
  //public static final String IMAGE_DIR = "/tmp/image_archive";
  public static PhotoArchive photoArchive = new PhotoArchive(ARCHIVE_NAME, IMAGE_DIR);


  public void runDemo() {
    photoArchive.initialize();
    System.out.println(ARCHIVE_NAME + " created!");
    addHanoverLogo();
    System.out.println("\nCurrent Archive:\n");
    printPhotoList();
    //System.out.println("Our Archive has " + photoArchive.getPhotoList().getLength() + " photo!");
    // Keep demo running so archive files can be checked (ugly comment)
    waitForEnter();
  }

  public void printLabels(Photo photo) {
    photo.addField(Field.Kind.LOCATION, new StringFieldValue("Hanover"));
    photo.addField(Field.Kind.TITLE, new StringFieldValue("Title"));
    photo.addField(Field.Kind.SUBJECT, new StringFieldValue("Sports"));
    for (Field label : photo.getFields()) {
      System.out.println(label.getKind() + ": " + label.getValue());
    }
  }

  public void printPhotoList() {
    for (Photo photo : photoArchive.getPhotoList()) {
      System.out.println("photo id: " + photo.getID());
      System.out.println("title: " + photo.getFieldValue(Field.Kind.TITLE));
      System.out.println("image location: " + photo.getImageLocation());
    }
  }

  private void waitForEnter() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("<enter> when finished");
    while (scanner.hasNextLine()) {

    }
  }

  public void addHanoverLogo() {
    Photo photo = new Photo("https://www.hanover.edu/images/site/logos/logo.png");
    photo.addField(Field.Kind.TITLE, new StringFieldValue("Hanover College Logo"));
    photoArchive.addPhoto(photo);
  }

  public void addPhotoFromUser() {
    Scanner scanner = new Scanner(System.in);
    Photo photo = new Photo(getURL(scanner));
    photo.addField(Field.Kind.TITLE, new StringFieldValue(getTitle(scanner)));
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
