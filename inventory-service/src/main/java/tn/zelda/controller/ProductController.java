package tn.zelda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @RequestMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}