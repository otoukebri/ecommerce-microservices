package tn.zelda.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;
import tn.zelda.domain.Product;

@Repository
public interface ProductRepository extends ElasticsearchCrudRepository<Product, Long> {
}
