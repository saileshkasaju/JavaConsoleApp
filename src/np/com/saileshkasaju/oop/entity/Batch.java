package np.com.saileshkasaju.oop.entity;

/**
 * Created by Edge on 1/29/2017.
 */
public class Batch {
  private int id;
  private String title;
  private Course course; //courseId
  private boolean status;
  private Facilitator facilitator; //facilitatorId
  private Timing timing;
  
  public Batch() {
  }
  
  public Batch(int id, String title, Course course, boolean status, Facilitator facilitator, Timing timing) {
    this.id = id;
    this.title = title;
    this.course = course;
    this.status = status;
    this.facilitator = facilitator;
    this.timing = timing;
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
  
  public Course getCourse() {
    return course;
  }
  
  public void setCourse(Course course) {
    this.course = course;
  }
  
  public boolean isStatus() {
    return status;
  }
  
  public void setStatus(boolean status) {
    this.status = status;
  }
  
  public Facilitator getFacilitator() {
    return facilitator;
  }
  
  public void setFacilitator(Facilitator facilitator) {
    this.facilitator = facilitator;
  }
  
  public Timing getTiming() {
    return timing;
  }
  
  public void setTiming(Timing timing) {
    this.timing = timing;
  }
}
