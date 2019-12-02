package tn.zelda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.zelda.application.ProductService;
import tn.zelda.domain.Product;


import java.util.List;

/**
 * Created by zelda on 31/01/17.
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @RequestMapping("/employee")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}