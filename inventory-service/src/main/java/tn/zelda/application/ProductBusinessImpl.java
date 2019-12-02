package tn.zelda.application;

import org.springframework.stereotype.Service;
import tn.zelda.domain.Product;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductBusinessImpl implements ProductService {

    public List<Product> getProducts() {
        return Arrays.asList(
                new Product(1L, "Nexus5", 350),
                new Product(2L,"Nokia3310", 10)
        );

    }
}
