package tn.zelda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.zelda.domain.Product;
import tn.zelda.repository.ProductRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public Iterable<Product> getAll() {
        System.out.println("ProductController.getAll");
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable Long  id) {
        return productRepository.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

}
