package tn.zelda.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.zelda.domain.Product;
import tn.zelda.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductBusinessImpl implements ProductBusiness {

    // @Autowired
    // ProductRepository productRepository;

    public List<Product> getProducts() {
        // return null;
        //return productRepository.findAll();
        return Arrays.asList(
                new Product(1L, "Nexus5","e", 350),
                new Product(2L,"Nokia3310","r", 10)
        );

    }
}
