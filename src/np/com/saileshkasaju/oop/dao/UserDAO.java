package np.com.saileshkasaju.oop.dao;

import java.util.List;
import np.com.saileshkasaju.oop.entity.User;
/**
 * Created by Edge on 1/19/2017.
 */
public interface UserDAO {
  List<User> getAll();
  User getById(int id);
  boolean insert(User u);
  User login(String username, String password);
}
