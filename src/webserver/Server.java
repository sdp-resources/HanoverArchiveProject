package webserver;

import photoarchives.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

// By default serving at http://localhost:4567
public class Server {

  private static String archiveDir;
  private static PhotoArchive photoArchive;
  private static HandlebarsTemplateEngine templateEngine = new HandlebarsTemplateEngine();

  public static void main(String[] args) {
    staticFiles.location("/public");
    get("/", Server::serveIndex);
    post("/login", Server::processLogin);
    get("/photos", Server::showPhotoList);
    get("/upload", Server::getUploadForm);
    post("/upload", Server::uploadPhoto);
    get("/showphoto", Server::showPhoto);
    //post("/labelphoto", Server::photoLabel);

    setupArchive();
    populateArchive();
  }

  private static Object serveIndex(Request req, Response res) {
    return serveTemplate("/login.handlebars", new HashMap<>());
  }

  private static Object processLogin(Request req, Response res) {
    System.out.println(req.queryParams("username"));
    System.out.println(req.queryParams("password"));
    return "null";
  }

  private static Object showPhotoList(Request req, Response res) {
    // TODO: Get this displaying photos

    HashMap<Object, Object> returnedHash = new HashMap<>();
    returnedHash.put("photoArchive", photoArchive);
    return serveTemplate("/PhotoList.handlebars", returnedHash);
  }

  private static Object showPhoto(Request req, Response res) {
    HashMap<Object, Object> returnedHash = new HashMap<>();
    PhotoList photos = photoArchive.getPhotoList();
    returnedHash.put("photo", photos.get(0));
    return serveTemplate("/ShowPhoto.handlebars", returnedHash);
  }

//  private static Object photoLabel(Request req, Response res) {
//    String titleLabel = req.queryParams("title");
//    String descriptionLabel = req.queryParams("description");
//    String dateLabel = req.queryParams("date");
//    String subjectLabel = req.queryParams("subject");
//    String hanoverSubjectLabel = req.queryParams("hanover subject");
//    String locationLabel = req.queryParams("location");
//    Field exampleTitle = new Field(titleLabel, archiveDir);
//  }

  private static Object getUploadForm(Request req, Response res) {
    return serveTemplate("/UploadPhoto.handlebars", new HashMap<>());
  }

  private static Object uploadPhoto(Request req, Response res){
    String photoLink = req.queryParams("inputPhotoSource");
    Photo examplePhoto = new Photo(photoLink, archiveDir);
    photoArchive.addPhoto(examplePhoto);
    return null;
  }

  private static String serveTemplate(String templatePath, HashMap<Object, Object> model) {
    return templateEngine.render(new ModelAndView(model, templatePath));
  }

  private static void setupArchive() {
    archiveDir = "assets/public/image_archive";
    photoArchive = new PhotoArchive("Archive", archiveDir);
    photoArchive.initialize();
  }

  private static void populateArchive() {
    String url1 = "https://upload.wikimedia" +
                                             ".org/wikipedia/commons/thumb/c/c7/John_Finley_Crowe.jpg/506px-John_Finley_Crowe.jpg";
    String url2 = "https://upload.wikimedia" +
                                             ".org/wikipedia/commons/thumb/d/dc/Crowe-Garritt_House_in_color.jpg/800px-Crowe-Garritt_House_in_color.jpg";
    String url3 = "https://upload.wikimedia" +
                                             ".org/wikipedia/commons/1/1f/Hanover_College_Campus_Aerial.jpg";

    archiveDir = "assets/public/image_archive";
    photoArchive = new PhotoArchive("Archive", archiveDir);
    photoArchive.initialize();

    Photo photo;
    photo = new Photo(url1, archiveDir);
    photo.addField(Field.Kind.TITLE, "John Finley Crow");
    photo.addField(Field.Kind.LOCATION, "unknown");
    photoArchive.addPhoto(photo);

    photo = new Photo(url2, archiveDir);
    photo.addField(Field.Kind.TITLE, "Crowe-Garrett House");
    photo.addField(Field.Kind.LOCATION, "Hanover");
    photoArchive.addPhoto(photo);

    photo = new Photo(url3, archiveDir);
    photo.addField(Field.Kind.TITLE, "Hanover College Campus");
    photo.addField(Field.Kind.LOCATION, "Hanover");
    photoArchive.addPhoto(photo);
  }
}
