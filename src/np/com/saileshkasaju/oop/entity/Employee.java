package np.com.saileshkasaju.oop.entity;

/**
 * Created by Edge on 1/19/2017.
 */
public class Employee {
  private int id;
  private String firstName, lastName, email, contactNo;
  
  public Employee() {
  }
  
  public Employee(int id, String firstName, String lastName, String email, String contactNo) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.contactNo = contactNo;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getContactNo() {
    return contactNo;
  }
  
  public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
  }
}
