package tn.zelda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.zelda.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
