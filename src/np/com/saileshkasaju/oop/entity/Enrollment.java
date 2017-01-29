package np.com.saileshkasaju.oop.entity;

import java.sql.Date;

/**
 * Created by Edge on 1/29/2017.
 */
public class Enrollment {
  private int id;
  private Date enrollmentDate;
  private int batchId;
  private Student student; // studentId;
  private Discount discount; //int discountId;
  
  public Enrollment() {
  }
  
  public Enrollment(int id, Date enrollmentDate, int batchId, Student student, Discount discount) {
    this.id = id;
    this.enrollmentDate = enrollmentDate;
    this.batchId = batchId;
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
  
  public int getBatchId() {
    return batchId;
  }
  
  public void setBatchId(int batchId) {
    this.batchId = batchId;
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
