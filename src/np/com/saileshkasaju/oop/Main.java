package np.com.saileshkasaju.oop;

import np.com.saileshkasaju.oop.dao.EmployeeDAO;
import np.com.saileshkasaju.oop.dao.ProductDAO;
import np.com.saileshkasaju.oop.dao.UserDAO;
import np.com.saileshkasaju.oop.dao.impl.EmployeeDAOImpl;
import np.com.saileshkasaju.oop.dao.impl.ProductDAOImpl;
import np.com.saileshkasaju.oop.dao.impl.UserDAOImpl;
import np.com.saileshkasaju.oop.entity.User;
import np.com.saileshkasaju.oop.util.DataLoader;

import java.io.*;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    User user;
    UserDAO userDAO = new UserDAOImpl();
    String userFile = "User.csv";
    String productFile = "Product.csv";
    String employeeFile = "Employee.csv";
    
    File file = new File(userFile);
    System.out.println("Our current file path is\n"+file.getAbsolutePath());
    if (file.exists()) {
      System.out.println("loading user data");
      DataLoader dataLoader = new DataLoader();
      try {
        dataLoader.setUserDAO(userDAO);
        dataLoader.loadUsers(userFile);
      } catch (IOException e) {
        System.out.println("Can't read file");
      } finally {
        System.out.println("Reading user data done");
      }
    } else {
      System.out.println("Program can't run because database of users not found");
      System.exit(0);
    }
    /* ------------------------------------
    Authentication module
    --------------------------------------- */
    String username;
    String password;
    boolean verified = false;
    Scanner in = new Scanner(System.in);
    while(true) {
      System.out.println("Welcome to java console application");
      System.out.print("Enter your username: ");
      username = in.nextLine();
      System.out.print("Enter your password: ");
      password = in.nextLine();
      
      System.out.println("Verifying username and password in out data-center...");
      user = userDAO.login(username, password);
      if (user != null) {
        verified = true;
        System.out.println("Welcome " + user.getUsername());
      }
      if (verified) {
        break;
      }
    }
    
    
    /* --------------------------------------
    Main Module
    ----------------------------------------- */
    ProductDAO productDAO = new ProductDAOImpl();
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    System.out.println("loading main module data");
    DataLoader dataLoader = new DataLoader();
    try {
      dataLoader.setProductDAO(productDAO);
      dataLoader.loadProducts(productFile);
      dataLoader.setEmployeeDAO(employeeDAO);
      dataLoader.loadEmployees(employeeFile);
    } catch (IOException e) {
      System.out.println("Can't read file");
    } finally {
      System.out.println("Reading main module data done");
    }
    
    
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    String line = "";
    System.out.print("$"+user.getUsername()+">");
    try {
      while(!(line = reader.readLine()).equalsIgnoreCase("exit")) {
        String[] tokens = line.split(" ");
        System.out.print("$"+user.getUsername()+">");
      }
    } catch (IOException e) {
      System.out.println("I/O Exception occured");
    }
  }
}
