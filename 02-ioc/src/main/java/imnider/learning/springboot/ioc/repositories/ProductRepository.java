package imnider.learning.springboot.ioc.repositories;

import java.util.List;

import imnider.learning.springboot.ioc.models.Product;

public class ProductRepository {
    
    private List<Product> products;

    public ProductRepository() {
        this.products = List.of(
            new Product("Laptop", 999.99),
            new Product("Smartphone", 499.99),
            new Product("Tablet", 299.99)
        );
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
            .filter(product -> product.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
