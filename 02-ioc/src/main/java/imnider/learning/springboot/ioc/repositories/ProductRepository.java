package imnider.learning.springboot.ioc.repositories;

import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import imnider.learning.springboot.ioc.models.Product;
import tools.jackson.databind.ObjectMapper;

@Repository
public class ProductRepository implements IProductRepository {
    
    private List<Product> products;

    public ProductRepository() {
        ClassPathResource resource = new ClassPathResource("json/products.json");  
        ObjectMapper mapper = new ObjectMapper();
        try {
            products = List.of(mapper.readValue(resource.getInputStream(), Product[].class));
        } catch (Exception e) {
            e.printStackTrace();
            products = List.of();
        }
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
