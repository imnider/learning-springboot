package imnider.learning.springboot.ioc.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import imnider.learning.springboot.ioc.models.Product;

@Repository
public class ProductRepository implements IProductRepository {
    
    private List<Product> products;

    public ProductRepository() {
        this.products = List.of(
            new Product("Laptop", 999.99),
            new Product("Smartphone", 499.99),
            new Product("Tablet", 299.99)
        );
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        return products.stream()
            .filter(product -> product.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
