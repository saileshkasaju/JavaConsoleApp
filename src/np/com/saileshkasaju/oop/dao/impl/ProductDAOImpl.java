package np.com.saileshkasaju.oop.dao.impl;

import np.com.saileshkasaju.oop.dao.ProductDAO;
import np.com.saileshkasaju.oop.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edge on 1/19/2017.
 */
public class ProductDAOImpl implements ProductDAO {
  private List<Product> productList = new ArrayList<>();
  
  @Override
  public List<Product> getAll() {
    return productList;
  }
  
  @Override
  public Product getById(int id) {
    for (Product product: productList) {
      if (product.getId() == id) {
        return product;
      }
    }
    return null;
  }
  @Override
  public boolean removeById(int id) {
    if (productList.remove(getById(id))) {
      return true;
    }else {
      return false;
    }
  }
  
  private int generateId() {
    int id = 0;
    for(Product product: productList) {
      if (product.getId() > id) {
        id = product.getId();
      }
    }
    return ( id + 1 );
  }
  @Override
  public boolean insert(Product product) {
    if (product.getId() == 0) {
      product.setId(generateId());
    }
    return productList.add(product);
  }
}
