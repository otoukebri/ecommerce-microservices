package tn.zelda.repository;

import tn.zelda.domain.Product;

import java.util.List;


public interface CustomProductRepository {
    List<Product> search(Product product);
}
