package tn.zelda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.zelda.application.ProductBusiness;
import tn.zelda.domain.Product;


import java.util.List;

/**
 * Created by zelda on 31/01/17.
 */

@RestController("/api/v1")
public class ProductController {

    @Autowired
    ProductBusiness productService;

    @CacheEvict(allEntries = true)
    @Cacheable
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
