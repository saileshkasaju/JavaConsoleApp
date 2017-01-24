package np.com.saileshkasaju.oop.dao;

import np.com.saileshkasaju.oop.entity.Employee;
import java.util.List;

/**
 * Created by Edge on 1/19/2017.
 */
public interface EmployeeDAO {
  List<Employee> getAll();
  
  Employee getById(int id);
  boolean removeById(int id);
  boolean insert(Employee employee);
}
