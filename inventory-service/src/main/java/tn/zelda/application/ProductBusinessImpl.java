package tn.zelda.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.zelda.domain.Product;
import tn.zelda.repository.ProductRepository;

import java.util.List;

@Service
public class ProductBusinessImpl implements ProductBusiness {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
