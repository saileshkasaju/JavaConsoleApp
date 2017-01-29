package np.com.saileshkasaju.oop.entity;

/**
 * Created by Edge on 1/29/2017.
 */
public class Discount {
  private int id;
  private String title;
  private float percentage;
  private boolean status;
  
  public Discount() {
  }
  
  public Discount(int id, String title, float percentage, boolean status) {
    this.id = id;
    this.title = title;
    this.percentage = percentage;
    this.status = status;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public float getPercentage() {
    return percentage;
  }
  
  public void setPercentage(float percentage) {
    this.percentage = percentage;
  }
  
  public boolean isStatus() {
    return status;
  }
  
  public void setStatus(boolean status) {
    this.status = status;
  }
}
