package np.com.saileshkasaju.oop.entity;

import java.sql.Time;

/**
 * Created by Edge on 1/29/2017.
 */
public class Timing {
  private int id;
  private String title;
  private Time startTime;
  private Time endTime;
  
  public Timing() {
  }
  
  public Timing(int id, String title, Time startTime, Time endTime) {
    this.id = id;
    this.title = title;
    this.startTime = startTime;
    this.endTime = endTime;
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
  
  public Time getStartTime() {
    return startTime;
  }
  
  public void setStartTime(Time startTime) {
    this.startTime = startTime;
  }
  
  public Time getEndTime() {
    return endTime;
  }
  
  public void setEndTime(Time endTime) {
    this.endTime = endTime;
  }
}
