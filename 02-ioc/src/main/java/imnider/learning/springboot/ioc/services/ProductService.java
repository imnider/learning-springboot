package imnider.learning.springboot.ioc.services;

import java.util.List;

import imnider.learning.springboot.ioc.models.Product;
import imnider.learning.springboot.ioc.repositories.ProductRepository;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();
    
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts().stream().map(product -> {
            Double taxPrice = product.getPrice() * 1.1;
            Product newProduct = product.clone();
            newProduct.setPrice(taxPrice);
            return newProduct;
        }).toList();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
}
