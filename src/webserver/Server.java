package webserver;

import photoarchives.PhotoArchive;
import photoarchives.PhotoList;
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
    archiveDir = "assets/public/image_archive";
    photoArchive = new PhotoArchive("Archive", archiveDir);
    HashMap<Object, Object> returnedHash = new HashMap<>();
    returnedHash.put("values", photoArchive);
    return serveTemplate("/profilesList.handlebars", returnedHash);
  }

  private static String serveTemplate(String templatePath, HashMap<Object, Object> model) {
    return templateEngine.render(new ModelAndView(model, templatePath));
  }
}
