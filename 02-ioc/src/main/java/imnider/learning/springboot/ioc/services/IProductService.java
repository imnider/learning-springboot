package imnider.learning.springboot.ioc.services;

import java.util.List;

import imnider.learning.springboot.ioc.models.Product;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
}
