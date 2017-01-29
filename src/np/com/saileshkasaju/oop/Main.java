package np.com.saileshkasaju.oop;

import np.com.saileshkasaju.oop.dao.EmployeeDAO;
import np.com.saileshkasaju.oop.dao.ProductDAO;
import np.com.saileshkasaju.oop.dao.UserDAO;
import np.com.saileshkasaju.oop.dao.impl.EmployeeDAOImpl;
import np.com.saileshkasaju.oop.dao.impl.ProductDAOImpl;
import np.com.saileshkasaju.oop.dao.impl.UserDAOImpl;
import np.com.saileshkasaju.oop.entity.Employee;
import np.com.saileshkasaju.oop.entity.Product;
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
    System.out.println("type help command for all features.\n" +
      "type menu to show menu\n");
    String line = "";
    System.out.print("$"+user.getUsername()+">");
    try {
      while(!(line = reader.readLine()).equalsIgnoreCase("exit")) {
        String[] tokens = line.split(" ");
        try {
          switch (tokens[0]) {
            case "add":
              if (tokens[1].equalsIgnoreCase("employee")) {
                Employee employee = new Employee();
                employee.setId(0);
                System.out.print("Enter employee's first name: ");
                employee.setFirstName(in.nextLine());
                System.out.print("Enter employee's last name: ");
                employee.setLastName(in.nextLine());
                System.out.print("Enter employee's email: ");
                employee.setEmail(in.nextLine());
                System.out.print("Enter employee's contact number: ");
                employee.setContactNo(in.nextLine());
                System.out.print("Confirm employee details?(Y/N)");
                if (in.nextLine().equalsIgnoreCase("y")) {
                  employeeDAO.insert(employee);
                  System.out.println("Employee saved on cache. Type 'save' to confirm save on file.");
                } else {
                  System.out.println("Saving cancelled by user.");
                }
              } else if (tokens[1].equalsIgnoreCase("product")) {
                Product product = new Product();
                System.out.print("Enter product name: ");
                product.setName(in.nextLine());
                System.out.print("Enter product quantity: ");
                product.setQuantity(Integer.parseInt(in.nextLine()));
                System.out.print("Enter employee's email: ");
                product.setPrice(Double.parseDouble(in.nextLine()));
                System.out.print("Confirm product details?(Y/N)");
                if (in.nextLine().equalsIgnoreCase("y")) {
                  productDAO.insert(product);
                  System.out.println("Product saved on cache. Type 'save' to confirm save on file.");
                } else {
                  System.out.println("Saving cancelled by user.");
                }
              } else {
                System.out.println("Syntax error. Type help for proper syntax");
              }
              break;
            case "save":
              dataLoader.saveEmployees(employeeFile);
              dataLoader.saveProducts(productFile);
              dataLoader.saveUsers(userFile);
              break;
            case "show":
              if (tokens[1].equalsIgnoreCase("employee")) {
                System.out.println("List of all employees:");
                for (Employee employee:
                  employeeDAO.getAll()) {
                  System.out.println(employee.getId() + ","
                    + employee.getFirstName() + ","
                    + employee.getLastName() + ","
                    + employee.getEmail() + ","
                    + employee.getContactNo());
                }
              } else if (tokens[1].equalsIgnoreCase("product")) {
                for (Product product:
                  productDAO.getAll()) {
                  System.out.println(product.getId() + ","
                    + product.getName() + ","
                    + product.getQuantity() + ","
                    + product.getPrice());
                }
              } else {
                System.out.println("Syntax error. Type help for proper syntax");
              }
              break;
            case "edit":
              if (tokens[1].equalsIgnoreCase("employee")) {
                System.out.print("Enter employee's id: ");
                int id = Integer.parseInt(in.nextLine());
                Employee employee = employeeDAO.getById(id);
                if (employee != null) {
                  System.out.println("Current details:");
                  System.out.println(employee.getId() + ","
                    + employee.getFirstName() + ","
                    + employee.getLastName() + ","
                    + employee.getEmail() + ","
                    + employee.getContactNo());
                  System.out.print("Enter employee's first name: ");
                  String firstName = in.nextLine();
                  System.out.print("Enter employee's last name: ");
                  String lastName = in.nextLine();
                  System.out.print("Enter employee's email: ");
                  String email = in.nextLine();
                  System.out.print("Enter employee's contact number: ");
                  String contactNumber = in.nextLine();
                  System.out.print("Confirm employee details?(Y/N)");
                  if (in.nextLine().equalsIgnoreCase("y")) {
                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employee.setEmail(email);
                    employee.setContactNo(contactNumber);
                    System.out.println("Employee saved on cache. Type 'save' to confirm save on file.");
                  } else {
                    System.out.println("Saving cancelled by user.");
                  }
                } else {
                  System.out.println("Employee not found in database.");
                }
        
              } else if (tokens[1].equalsIgnoreCase("product")) {
                System.out.print("Enter product id: ");
                int id = Integer.parseInt(in.nextLine());
                Product product = productDAO.getById(id);
                if (product != null) {
                  System.out.println("Current details:");
                  System.out.println(product.getId() + ","
                    + product.getName() + ","
                    + product.getQuantity() + ","
                    + product.getPrice());
                  System.out.print("Enter product name: ");
                  String name = in.nextLine();
                  System.out.print("Enter product quantity: ");
                  int quantity = Integer.parseInt(in.nextLine());
                  System.out.print("Enter product price: ");
                  double price = Double.parseDouble(in.nextLine());
                  System.out.print("Confirm product details?(Y/N)");
                  if (in.nextLine().equalsIgnoreCase("y")) {
                    product.setName(name);
                    product.setQuantity(quantity);
                    product.setPrice(price);
                    System.out.println("Product saved on cache. Type 'save' to confirm save on file.");
                  } else {
                    System.out.println("Saving cancelled by user.");
                  }
                } else {
                  System.out.println("Product not found in database.");
                }
              }
              System.out.println("Edit block\n" +
                "Yet to be implemented.");
              break;
            case "del":
              if (tokens[1].equalsIgnoreCase("employee")) {
                System.out.print("Enter employee's id: ");
                int id = Integer.parseInt(in.nextLine());
                Employee employee = employeeDAO.getById(id);
                if (employee != null) {
                  System.out.println("Are you sure you want to delete the following record:");
                  System.out.println(employee.getId() + ","
                    + employee.getFirstName() + ","
                    + employee.getLastName() + ","
                    + employee.getEmail() + ","
                    + employee.getContactNo());
                  System.out.print("Type the name of employee's first name to delete it.");
                  if (in.nextLine().equalsIgnoreCase(employee.getFirstName())) {
                    if (employeeDAO.removeById(employee.getId())) {
                      System.out.println("Employee removed on cache. Type 'save' to confirm remove on file.");
                    } else {
                      System.out.println("Error removing employee");
                    }
                  } else {
                    System.out.println("Delete cancelled by user.");
                  }
                } else {
                  System.out.println("Employee not found in database.");
                }
        
              } else if (tokens[1].equalsIgnoreCase("product")) {
                System.out.print("Enter product's id: ");
                int id = Integer.parseInt(in.nextLine());
                Product product = productDAO.getById(id);
                if (product != null) {
                  System.out.println("Are you sure you want to delete the following record:");
                  System.out.println(product.getId() + ","
                    + product.getName() + ","
                    + product.getQuantity() + ","
                    + product.getPrice());
                  System.out.print("Type the name of product first name to delete it.");
                  if (in.nextLine().equalsIgnoreCase(product.getName())) {
                    if (productDAO.removeById(product.getId())) {
                      System.out.println("Product removed on cache. Type 'save' to confirm remove on file.");
                    } else {
                      System.out.println("Error removing product");
                    }
                  } else {
                    System.out.println("Delete cancelled by user.");
                  }
                } else {
                  System.out.println("Product not found in database.");
                }
              } else {
                System.out.println("Syntax error. Type help for proper syntax");
              }
              break;
            case "help":
              System.out.println("Help block\n" +
                "Yet to be implemented.");
              break;
            case "menu":
              System.out.println("Menu block\n" +
                "Yet to be implemented.\n" +
                "Should display current menu");
              break;
            default:
              System.out.println("command not found.\nAsk the programmer to add this feature.");
              break;
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("Syntax error");
        } finally {
          System.out.print("$"+user.getUsername()+">");
        }
      }
    } catch (IOException e) {
      System.out.println("I/O Exception occured");
    }
  }
}
