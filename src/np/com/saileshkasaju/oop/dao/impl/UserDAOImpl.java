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
  public boolean removeById(int id) {
    if (userList.remove(getById(id))) {
      return true;
    }else {
      return false;
    }
  }
  
  private int generateId() {
    int id = 0;
    for(User user: userList) {
      if (user.getId() > id) {
        id = user.getId();
      }
    }
    return ( id + 1 );
  }
  @Override
  public boolean insert(User user) {
    if (user.getId() == 0) {
      user.setId(generateId());
    }
    return userList.add(user);
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
