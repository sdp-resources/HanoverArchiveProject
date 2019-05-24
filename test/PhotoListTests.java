import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import photoarchives.*;
import photoarchives.SortingComparators.*;

import java.util.Iterator;

import static junit.framework.TestCase.assertSame;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PhotoListTests {
  private final String url1 = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/John_Finley_Crowe.jpg/506px-John_Finley_Crowe.jpg";
  private final String url2 = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Crowe-Garritt_House_in_color.jpg/800px-Crowe-Garritt_House_in_color.jpg";
  private final String url3 = "https://upload.wikimedia.org/wikipedia/commons/1/1f/Hanover_College_Campus_Aerial.jpg";
  private PhotoList photoList;
  private Photo photo;

  @Before
  public void setUp() {
    photoList = new PhotoList();
    photo = new Photo(url1, "/tmp");
  }

  @Test
  public void addOnePhoto_ExpectLengthToBeOne(){
    photoList.addPhoto(photo);
    assertEquals(photoList.getLength(), 1);

  }

  @Test
  public void getFirstPhoto_ListOfLengthOne() {
    photoList.addPhoto(photo);
    Photo photo = photoList.get(0);
    assertEquals(url1, photo.getRetrievedFromURL());
  }

  @Test
  public void getSecondPhoto_ListOfLengthThree() {
    addThreePhotosToList();
    Photo photo = photoList.get(1);
    assertEquals(url2, photo.getRetrievedFromURL());
  }

  @Test
  public void removeOnePhoto_ExpectLengthToBeZero(){
    photoList.addPhoto(photo);
    photoList.removePhoto(photo);
    assertEquals(photoList.getLength(), 0);
  }

  @Test
  public void clearPhotoList() {
    addThreePhotosToList();
    photoList.clear();
    assertEquals(0, photoList.getLength());
  }

  @Test
  public void whenAddingThreePhotos_LengthUpdates(){
    addThreePhotosToList();
    assertEquals(photoList.getLength(),3);
  }


  @Test
  public void whenListIsEmpty_hasNextIsFalse(){
    Iterator<Photo> iter = photoList.iterator();
    assertFalse(iter.hasNext());
  }

  @Test
  public void whenListIsNotEmpty_hasNextIsTrue(){
    addThreePhotosToList();
    Iterator<Photo> iter = photoList.iterator();
    assertTrue(iter.hasNext());
  }

  @Test
  public void whenNextIsCalled_ReturnNextPhoto() {
    addThreePhotosToList();
    Iterator<Photo> iter = photoList.iterator();
    Photo test = iter.next();
    assertEquals(url1, test.getRetrievedFromURL());
  }

  @Test
  public void callNextTwice_ExpectSecondItemInList() {
    addThreePhotosToList();
    Iterator<Photo> iter = photoList.iterator();
    Photo first = iter.next();
    Photo second = iter.next();
    assertEquals(url2, second.getRetrievedFromURL());
  }

  @Test
  public void searchForDate_Value1991_ListOfSizeOne_ExpectOneInFinalList() {
    photo.addField(Field.Kind.DATE, "1991");
    photoList.addPhoto(photo);
    PhotoList test = photoList.search(Field.Kind.DATE, "1991");
    assertEquals(1, test.getLength());
    assertEquals("1991", test.get(0).getFieldValue(Field.Kind.DATE));
  }

  @Test
  public void searchForDate_Value1991_ListOfSizeThree_ExpectTwoInFinalList() {
    addThreePhotosToList();
    PhotoList test = photoList.search(Field.Kind.DATE, "1991");
    assertEquals(2, test.getLength());
    assertEquals("1991", test.get(0).getFieldValue(Field.Kind.DATE));
    assertEquals("1991", test.get(1).getFieldValue(Field.Kind.DATE));
  }

  @Test
  public void searchForDate_Value1991_ListOfSizeThree_NoSuchFieldValue() {
    addThreePhotosToList();
    PhotoList test = photoList.search(Field.Kind.DATE, "2020");
    assertEquals(0, test.getLength());
  }

  private void addThreePhotosToList() {
    Photo p1 = new Photo(url1, "/tmp");
    Photo p2 = new Photo(url2, "/tmp") ;
    Photo p3 = new Photo(url3, "/tmp");
    photoList.addPhoto(p1);
    photoList.addPhoto(p2);
    photoList.addPhoto(p3);
    p1.addField(Field.Kind.DATE, "1991");
    p2.addField(Field.Kind.DATE, "1991");
    p3.addField(Field.Kind.DATE, "2005");
    p1.addField(Field.Kind.TITLE, "b");
    p2.addField(Field.Kind.TITLE, "c");
    p3.addField(Field.Kind.TITLE, "a");
    p1.addField(Field.Kind.SUBJECT, "Math");
    p2.addField(Field.Kind.SUBJECT, "CS");
    p3.addField(Field.Kind.SUBJECT, "Science");
    p1.addField(Field.Kind.HANOVER_SUBJECT, "Math");
    p2.addField(Field.Kind.HANOVER_SUBJECT, "CS");
    p3.addField(Field.Kind.HANOVER_SUBJECT, "Science");
    p1.addField(Field.Kind.LOCATION, "Lynn");
    p2.addField(Field.Kind.LOCATION,"CC");
    p3.addField(Field.Kind.LOCATION,"Wiley");
    p1.addField(Field.Kind.COLLECTION_NAME, "Name");
    p2.addField(Field.Kind.COLLECTION_NAME, "Collection");
    p3.addField(Field.Kind.COLLECTION_NAME, "Test");
  }

  @Test
  public void canSortPhotoListByTitle(){
    addThreePhotosToList();
    photoList.sort(new TitleSortingComparator());
    assertSame("a", photoList.get(0).getFieldValue(Field.Kind.TITLE));
    assertSame("b", photoList.get(1).getFieldValue(Field.Kind.TITLE));
    assertSame("c", photoList.get(2).getFieldValue(Field.Kind.TITLE));
  }

  @Test
  public void canSortPhotoListByDate(){
    addThreePhotosToList();
    Photo photo = new Photo();
    photo.addField(Field.Kind.DATE, "1950");
    photoList.addPhoto(photo);
    photoList.sort(new DateSortingComparator());
    assertSame("1950", photoList.get(0).getFieldValue(Field.Kind.DATE));
    assertSame("1991", photoList.get(1).getFieldValue(Field.Kind.DATE));
    assertSame("1991", photoList.get(2).getFieldValue(Field.Kind.DATE));
    assertSame("2005", photoList.get(3).getFieldValue(Field.Kind.DATE));
  }

  @Test
  public void canSortPhotoListBySubject(){
    addThreePhotosToList();
    photoList.sort(new SubjectSortingComparator());
    assertSame("CS", photoList.get(0).getFieldValue(Field.Kind.SUBJECT));
    assertSame("Math", photoList.get(1).getFieldValue(Field.Kind.SUBJECT));
    assertSame("Science", photoList.get(2).getFieldValue(Field.Kind.SUBJECT));
  }

  @Test
  public void canSortPhotoListByHanover_Subject(){
    addThreePhotosToList();
    photoList.sort(new HanoverSubjectSortingComparator());
    assertSame("CS", photoList.get(0).getFieldValue(Field.Kind.HANOVER_SUBJECT));
    assertSame("Math", photoList.get(1).getFieldValue(Field.Kind.HANOVER_SUBJECT));
    assertSame("Science", photoList.get(2).getFieldValue(Field.Kind.HANOVER_SUBJECT));
  }

  @Test
  public void canSortPhotoListByLocation(){
    addThreePhotosToList();
    photoList.sort(new LocationSortingComparator());
    assertSame("CC", photoList.get(0).getFieldValue(Field.Kind.LOCATION));
    assertSame("Lynn", photoList.get(1).getFieldValue(Field.Kind.LOCATION));
    assertSame("Wiley", photoList.get(2).getFieldValue(Field.Kind.LOCATION));
  }

  @Test
  public void canSortPhotoListByCollectionName(){
    addThreePhotosToList();
    photoList.sort(new CollectionNameSortingComparator());
    assertSame("Collection", photoList.get(0).getFieldValue(Field.Kind.COLLECTION_NAME));
    assertSame("Name", photoList.get(1).getFieldValue(Field.Kind.COLLECTION_NAME));
    assertSame("Test", photoList.get(2).getFieldValue(Field.Kind.COLLECTION_NAME));
  }
}
