package np.com.saileshkasaju.oop.dao.impl;


import np.com.saileshkasaju.oop.dao.UserDAO;
import np.com.saileshkasaju.oop.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edge on 1/19/2017.
 */
public class UserDAOImpl implements UserDAO {
  private List<User> userList = new ArrayList<>();
  @Override
  public List<User> getAll() {
    return userList;
  }
  
  @Override
  public User getById(int id) {
    for(User user: userList) {
      if(user.getId() == id)
        return user;
    }
    return null;
  }
  
  @Override
  public boolean insert(User u) {
    return userList.add(u);
  }
  
  @Override
  public User login(String username, String password) {
    System.out.println("Checking username and password");
    for(User user: userList) {
      if(user.getUsername().equals(username) && user.getPassword().equals(password))
        return user;
    }
    return null;
  }
}
