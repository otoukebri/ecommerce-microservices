package tn.zelda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.zelda.domain.Product;
import tn.zelda.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/all")
    public Iterable<Product> getAll() {
        System.out.println("ProductController.getAll");
        return productRepository.findAll();
    }
}
