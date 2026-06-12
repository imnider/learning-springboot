package imnider.learning.springboot.ioc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imnider.learning.springboot.ioc.models.Product;
import imnider.learning.springboot.ioc.repositories.IProductRepository;

@Service
public class ProductService implements IProductService {
    
    @Autowired
    private IProductRepository productRepository;
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts().stream().map(product -> {
            Double taxPrice = product.getPrice() * 1.1;
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
