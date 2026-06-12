package imnider.learning.springboot.ioc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imnider.learning.springboot.ioc.models.Product;
import imnider.learning.springboot.ioc.services.IProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
}
