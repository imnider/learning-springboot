package imnider.learning.springboot.ioc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import imnider.learning.springboot.ioc.models.Product;
import imnider.learning.springboot.ioc.repositories.IProductRepository;

@Service
public class ProductService implements IProductService {
    
    private IProductRepository productRepository;
    private Environment env;

    public ProductService(@Autowired IProductRepository productRepository, @Autowired Environment env) {
        this.productRepository = productRepository;
        this.env = env;
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts().stream().map(product -> {
            Double taxPrice = product.getPrice() * env.getProperty("config.tax", Double.class, 1.0);
            Product newProduct = product.clone();
            newProduct.setPrice(taxPrice);
            return newProduct;
        }).toList();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
}
