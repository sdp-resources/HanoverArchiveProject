package photoarchives;

import java.util.ArrayList;
import java.util.List;

public class PhotoDetails {
  private List<PhotoField> labels;



  public PhotoDetails(){
    labels = new ArrayList<>();
  }

  public boolean isEmpty() {
    return labels.isEmpty();
  }


  public Object getLabels() {
    return labels;
  }
}
