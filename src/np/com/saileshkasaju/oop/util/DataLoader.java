package np.com.saileshkasaju.oop.util;

import np.com.saileshkasaju.oop.dao.EmployeeDAO;
import np.com.saileshkasaju.oop.dao.ProductDAO;
import np.com.saileshkasaju.oop.dao.UserDAO;
import np.com.saileshkasaju.oop.dao.impl.EmployeeDAOImpl;
import np.com.saileshkasaju.oop.dao.impl.ProductDAOImpl;
import np.com.saileshkasaju.oop.dao.impl.UserDAOImpl;
import np.com.saileshkasaju.oop.entity.Employee;
import np.com.saileshkasaju.oop.entity.Product;
import np.com.saileshkasaju.oop.entity.User;

import java.io.IOException;

/**
 * Created by Edge on 1/19/2017.
 */
public class DataLoader {
  private UserDAO userDAO = new UserDAOImpl();
  private ProductDAO productDAO = new ProductDAOImpl();
  private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
  
  public void setUserDAO(UserDAO userDAO) {
    this.userDAO = userDAO;
  }
  
  public void setProductDAO(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }
  
  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }
  
  public void loadUsers(String fileName) throws IOException {
    for (String userRow: FileHelper.readLines(fileName)) {
      System.out.println(userRow);
      String[] userColumn = userRow.split(",");
      if (userColumn.length == 4) {
        User user = new User(Integer.parseInt(userColumn[0]), userColumn[1], userColumn[2], Integer.parseInt(userColumn[3]));
        userDAO.insert(user);
      } else {
        System.out.println("no user here, something wrong with the pattern in User.csv");
      }
    }
  }
  public void loadProducts(String fileName) throws IOException {
    for (String productRow: FileHelper.readLines(fileName)) {
      System.out.println(productRow);
      String[] productColumn = productRow.split(",");
      if (productColumn.length == 4) {
        Product product = new Product(Integer.parseInt(productColumn[0]), productColumn[1], Integer.parseInt(productColumn[2]), Double.parseDouble(productColumn[3]));
        productDAO.insert(product);
      } else {
        System.out.println("no user here, something wrong with the pattern in User.csv");
      }
    }
  }
  public void loadEmployees(String fileName) throws IOException {
    for (String employeeRow: FileHelper.readLines(fileName)) {
      System.out.println(employeeRow);
      String[] employeeColumn = employeeRow.split(",");
      if (employeeColumn.length == 5) {
        Employee employee = new Employee(Integer.parseInt(employeeColumn[0]), employeeColumn[1], employeeColumn[2], employeeColumn[3], employeeColumn[4]);
        employeeDAO.insert(employee);
      } else {
        System.out.println("no user here, something wrong with the pattern in User.csv");
      }
    }
  }
}
