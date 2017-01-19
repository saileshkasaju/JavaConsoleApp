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
  public boolean insert(Product product) {
    return productList.add(product);
  }
}
