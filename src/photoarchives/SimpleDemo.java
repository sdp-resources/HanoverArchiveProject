package photoarchives;

import java.util.Scanner;

public class SimpleDemo  {
  public static final String ARCHIVE_NAME = "Hanover Photo Archive";
  public static final String IMAGE_DIR = "assets/public/image_archive";
  public static PhotoArchive photoArchive = new PhotoArchive(ARCHIVE_NAME, IMAGE_DIR);


  public void runDemo() {
    photoArchive.initialize();
    System.out.println(ARCHIVE_NAME + " created!");
    addJohnFinleyCrowe();
    System.out.println("\nCurrent Archive:\n");
    printPhotoList();
    //System.out.println("Our Archive has " + photoArchive.getPhotoList().getLength() + " photo!");
    // Keep demo running so archive files can be checked (ugly comment)
    waitForEnter();
  }

  public void printLabels(Photo photo) {
    photo.addField(Field.Kind.LOCATION, "Hanover");
    photo.addField(Field.Kind.TITLE, "Title");
    photo.addField(Field.Kind.SUBJECT, "Sports");
    for (Field label : photo.getFields()) {
      System.out.println(label.getKind() + ": " + label.getValue());
    }
  }

  public void printPhotoList() {
    for (Photo photo : photoArchive.getPhotoList()) {
      System.out.println("photo id: " + photo.getID());
      System.out.println("title: " + photo.getFieldValue(Field.Kind.TITLE));
      System.out.println("image location: " + photo.getImageFile());
    }
  }

  private void waitForEnter() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("<enter> when finished");
    while (! (scanner.nextLine()).isEmpty()) {
    }
  }

  public void addJohnFinleyCrowe() {
    String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/John_Finley_Crowe" +
                       ".jpg/506px-John_Finley_Crowe.jpg";
    Photo photo = new Photo(url, IMAGE_DIR);
    photo.addField(Field.Kind.TITLE, "John Finley Crowe");
    photoArchive.addPhoto(photo);
  }

  public void addPhotoFromUser() {
    Scanner scanner = new Scanner(System.in);
    Photo photo = new Photo(getURL(scanner), IMAGE_DIR);
    photo.addField(Field.Kind.TITLE, getTitle(scanner));
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
