package np.com.saileshkasaju.oop.entity;

import java.sql.Date;

/**
 * Created by Edge on 1/29/2017.
 */
public class Enrollment {
  private int id;
  private Date enrollmentDate;
  private Batch batch;
  private Student student; // studentId;
  private Discount discount; //int discountId;
  
  public Enrollment() {
  }
  
  public Enrollment(int id, Date enrollmentDate, Batch batch, Student student, Discount discount) {
    this.id = id;
    this.enrollmentDate = enrollmentDate;
    this.batch = batch;
    this.student = student;
    this.discount = discount;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public Date getEnrollmentDate() {
    return enrollmentDate;
  }
  
  public void setEnrollmentDate(Date enrollmentDate) {
    this.enrollmentDate = enrollmentDate;
  }
  
  public Batch getBatch() {
    return batch;
  }
  
  public void setBatch(Batch batch) {
    this.batch = batch;
  }
  
  public Student getStudent() {
    return student;
  }
  
  public void setStudent(Student student) {
    this.student = student;
  }
  
  public Discount getDiscount() {
    return discount;
  }
  
  public void setDiscount(Discount discount) {
    this.discount = discount;
  }
}
