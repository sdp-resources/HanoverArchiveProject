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
    photo.addField(Field.Kind.TITLE, new StringFieldValue("John Finley Crow"));
    photo.addField(Field.Kind.LOCATION, new StringFieldValue("unknown"));
    photoArchive.addPhoto(photo);

    photo = new Photo(url2, archiveDir);
    photo.addField(Field.Kind.TITLE, new StringFieldValue("Crowe-Garrett House"));
    photo.addField(Field.Kind.LOCATION, new StringFieldValue("Hanover"));
    photoArchive.addPhoto(photo);

    photo = new Photo(url3, archiveDir);
    photo.addField(Field.Kind.TITLE, new StringFieldValue("Hanover College Campus"));
    photo.addField(Field.Kind.LOCATION, new StringFieldValue("Hanover"));
    photoArchive.addPhoto(photo);
  }
}
