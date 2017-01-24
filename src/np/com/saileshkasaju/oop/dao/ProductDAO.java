package np.com.saileshkasaju.oop.dao;

import np.com.saileshkasaju.oop.entity.Product;
import java.util.List;

/**
 * Created by Edge on 1/19/2017.
 */
public interface ProductDAO {
  List<Product> getAll();
  
  Product getById(int id);
  boolean removeById(int id);
    boolean insert(Product product);
}
