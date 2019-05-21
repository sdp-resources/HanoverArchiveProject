import org.junit.Before;
import org.junit.Test;
import photoarchives.*;
import photoarchives.SortingComparators.*;

import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PhotoListTests {
  private PhotoList photoList;
  private Photo photo;

  @Before
  public void setUp() {
    photoList = new PhotoList();
    photo = new Photo("test source");
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
    assertEquals("test source", photo.getSource());
  }

  @Test
  public void getSecondPhoto_ListOfLengthThree() {
    addThreePhotosToList();
    Photo photo = photoList.get(1);
    assertEquals("test source2", photo.getSource());
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
    assertEquals("test source1", test.getSource());
  }

  @Test
  public void callNextTwice_ExpectSecondItemInList() {
    addThreePhotosToList();
    Iterator<Photo> iter = photoList.iterator();
    Photo first = iter.next();
    Photo second = iter.next();
    assertEquals("test source2", second.getSource());
  }

  @Test
  public void searchForDate_Value1991_ListOfSizeOne_ExpectOneInFinalList() {
    photo.addField(PhotoField.Kind.DATE, "1991");
    photoList.addPhoto(photo);
    PhotoList test = photoList.search(PhotoField.Kind.DATE, "1991");
    assertEquals(1, test.getLength());
    assertEquals("1991", test.get(0).getFieldValue(PhotoField.Kind.DATE));
  }

  @Test
  public void searchForDate_Value1991_ListOfSizeThree_ExpectTwoInFinalList() {
    addThreePhotosToList();
    PhotoList test = photoList.search(PhotoField.Kind.DATE, "1991");
    assertEquals(2, test.getLength());
    assertEquals("1991", test.get(0).getFieldValue(PhotoField.Kind.DATE));
    assertEquals("1991", test.get(1).getFieldValue(PhotoField.Kind.DATE));
  }

  @Test
  public void searchForDate_Value1991_ListOfSizeThree_NoSuchFieldValue() {
    addThreePhotosToList();
    PhotoList test = photoList.search(PhotoField.Kind.DATE, "2020");
    assertEquals(0, test.getLength());
  }

  private void addThreePhotosToList() {
    Photo p1 = new Photo("test source1" );
    p1.setID("First");
    Photo p2 = new Photo("test source2") ;
    p2.setID("Second");
    Photo p3 = new Photo("test source3");
    p3.setID("Third");
    photoList.addPhoto(p1);
    photoList.addPhoto(p2);
    photoList.addPhoto(p3);
    p1.addField(PhotoField.Kind.DATE, "1991");
    p2.addField(PhotoField.Kind.DATE, "1991");
    p3.addField(PhotoField.Kind.DATE, "2005");
    p1.addField(PhotoField.Kind.TITLE, "b");
    p2.addField(PhotoField.Kind.TITLE, "c");
    p3.addField(PhotoField.Kind.TITLE, "a");
    p1.addField(PhotoField.Kind.SUBJECT, "Math");
    p2.addField(PhotoField.Kind.SUBJECT, "CS");
    p3.addField(PhotoField.Kind.SUBJECT, "Science");
    p1.addField(PhotoField.Kind.HANOVER_SUBJECT, "Math");
    p2.addField(PhotoField.Kind.HANOVER_SUBJECT, "CS");
    p3.addField(PhotoField.Kind.HANOVER_SUBJECT, "Science");
    p1.addField(PhotoField.Kind.LOCATION, "Lynn");
    p2.addField(PhotoField.Kind.LOCATION, "CC");
    p3.addField(PhotoField.Kind.LOCATION, "Wiley");
    p1.addField(PhotoField.Kind.COLLECTION_NAME, "Name");
    p2.addField(PhotoField.Kind.COLLECTION_NAME, "Collection");
    p3.addField(PhotoField.Kind.COLLECTION_NAME, "Test");


  }
  @Test
  public void canSortPhotoListByTitle(){
    addThreePhotosToList();
    photoList.sort(new TitleSortingComparator());
    assertTrue(photoList.get(0).getFieldValue(PhotoField.Kind.TITLE) == "a");
    assertTrue(photoList.get(1).getFieldValue(PhotoField.Kind.TITLE) == "b");
    assertTrue(photoList.get(2).getFieldValue(PhotoField.Kind.TITLE) == "c");

  }
  @Test
  public void canSortPhotoListByDate(){
    addThreePhotosToList();
    Photo photo = new Photo();
    photo.addField(PhotoField.Kind.DATE, "1950");
    photoList.addPhoto(photo);
    photoList.sort(new DateSortingComparator());
    assertTrue(photoList.get(0).getFieldValue(PhotoField.Kind.DATE) == "1950");
    assertTrue(photoList.get(1).getFieldValue(PhotoField.Kind.DATE) == "1991");
    assertTrue(photoList.get(2).getFieldValue(PhotoField.Kind.DATE) == "1991");
    assertTrue(photoList.get(3).getFieldValue(PhotoField.Kind.DATE) == "2005");

  }
  @Test
  public void canSortPhotoListBySubject(){
    addThreePhotosToList();
    photoList.sort(new SubjectSortingComparator());
    assertTrue(photoList.get(0).getFieldValue(PhotoField.Kind.SUBJECT) == "CS");
    assertTrue(photoList.get(1).getFieldValue(PhotoField.Kind.SUBJECT) == "Math");
    assertTrue(photoList.get(2).getFieldValue(PhotoField.Kind.SUBJECT) == "Science");

  }
  @Test
  public void canSortPhotoListByHanover_Subject(){
    addThreePhotosToList();
    photoList.sort(new HanoverSubjectSortingComparator());
    assertTrue(photoList.get(0).getFieldValue(PhotoField.Kind.HANOVER_SUBJECT) == "CS");
    assertTrue(photoList.get(1).getFieldValue(PhotoField.Kind.HANOVER_SUBJECT) == "Math");
    assertTrue(photoList.get(2).getFieldValue(PhotoField.Kind.HANOVER_SUBJECT) == "Science");

  }
  @Test
  public void canSortPhotoListByLocation(){
    addThreePhotosToList();
    photoList.sort(new LocationSortingComparator());
    assertTrue(photoList.get(0).getFieldValue(PhotoField.Kind.LOCATION) == "CC");
    assertTrue(photoList.get(1).getFieldValue(PhotoField.Kind.LOCATION) == "Lynn");
    assertTrue(photoList.get(2).getFieldValue(PhotoField.Kind.LOCATION) == "Wiley");

  }
  @Test
  public void canSortPhotoListByCollectionName(){
    addThreePhotosToList();
    photoList.sort(new CollectionNameSortingComparator());
    assertTrue(photoList.get(0).getFieldValue(PhotoField.Kind.COLLECTION_NAME) == "Collection");
    assertTrue(photoList.get(1).getFieldValue(PhotoField.Kind.COLLECTION_NAME) == "Name");
    assertTrue(photoList.get(2).getFieldValue(PhotoField.Kind.COLLECTION_NAME) == "Test");

  }



}
