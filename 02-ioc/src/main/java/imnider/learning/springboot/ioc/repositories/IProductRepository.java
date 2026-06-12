package imnider.learning.springboot.ioc.repositories;

import java.util.List;

import imnider.learning.springboot.ioc.models.Product;

public interface IProductRepository {
    List<Product> getAllProducts();
    Product getProductById(int id);
}
