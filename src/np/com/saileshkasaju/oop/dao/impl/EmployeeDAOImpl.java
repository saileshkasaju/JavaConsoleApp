package np.com.saileshkasaju.oop.dao.impl;

import np.com.saileshkasaju.oop.dao.EmployeeDAO;
import np.com.saileshkasaju.oop.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edge on 1/19/2017.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
  
  private List<Employee> employeeList = new ArrayList<>();
  
  @Override
  public List<Employee> getAll() {
    return employeeList;
  }
  
  @Override
  public Employee getById(int id) {
    for(Employee employee: employeeList) {
      if (employee.getId() == id) {
        return employee;
      }
    }
    return null;
  }
  
  private int generateId() {
    int id = 0;
    for(Employee employee: employeeList) {
      if (employee.getId() > id) {
        id = employee.getId();
      }
    }
    return ( id + 1 );
  }
  @Override
  public boolean insert(Employee employee) {
//    System.out.println(employee.getId());
    return employeeList.add(employee);
  }
}
