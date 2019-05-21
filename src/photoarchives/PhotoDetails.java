package photoarchives;

import java.util.ArrayList;
import java.util.List;

public class PhotoDetails {
  private List<PhotoField> fields;



  public PhotoDetails(){
    fields = new ArrayList<>();
  }

  public boolean isEmpty() {
    return fields.isEmpty();
  }


  public Object getFields() {
    return fields;
  }
}
