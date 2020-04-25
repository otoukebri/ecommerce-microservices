package tn.zelda.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;
import tn.zelda.domain.Product;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Repository
public class CustomProductRepositoryImpl implements  CustomProductRepository {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public List<Product> search(Product product) {

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("code", product.getCode()).minimumShouldMatch("75%"))
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, Product.class);
    }

}
