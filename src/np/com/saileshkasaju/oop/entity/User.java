package np.com.saileshkasaju.oop.entity;

/**
 * Created by Edge on 1/19/2017.
 */
public class User {
  private int id;
  private String username, password;
  private int status;
  
  public User() {
  }
  
  public User(int id, String username, String password, int status) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.status = status;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public int isStatus() {
    return status;
  }
  
  public void setStatus(int status) {
    this.status = status;
  }
}
