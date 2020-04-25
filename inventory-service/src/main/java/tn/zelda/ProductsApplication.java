package tn.zelda;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import tn.zelda.domain.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

@EnableElasticsearchRepositories
@SpringBootApplication
public class ProductsApplication {

    private static final String INDEX_NAME = "product";
    private static final String INDEX_TYPE = "product";
    long COUNTER;

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }

    @Bean(name = "ConcurrentTaskExecutor")
    public TaskExecutor taskExecutor () {
        return new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3));
    }


    @Autowired
    ElasticsearchTemplate template;

    @Autowired
    TaskExecutor taskExecutor;

    @PostConstruct
    public void init() {
        if (!template.indexExists(INDEX_NAME)) {
            System.out.println("SampleDataSet.init");
            template.createIndex(INDEX_NAME);
            System.out.println("New index created: {}" + INDEX_NAME);
        }
        for (int i = 0; i < 10; i++) {
            taskExecutor.execute(() -> bulk());
        }
    }

    public void bulk() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<IndexQuery> queries = new ArrayList<>();
            int i = 0;
            for (Product product: products()) {
                IndexQuery indexQuery = new IndexQuery();
                indexQuery.setSource(mapper.writeValueAsString(product));
                indexQuery.setIndexName(INDEX_NAME);
                indexQuery.setType(INDEX_TYPE);
                queries.add(indexQuery);
            }

            if (queries.size() > 0) {
                template.bulkIndex(queries);
                System.out.println("ProductsApplication.bulk" + i);
            }
            template.refresh(INDEX_NAME);
            System.out.println("BulkIndex completed: {}" + ++COUNTER);
        } catch (Exception e) {
            System.out.println("Error bulk index" +  e);
        }
    }

    private List<Product> products() {
        Random random = new Random();
        List<Product> products  = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            String productCode =  "CODE_" + random.nextInt(1000000);
            System.out.println("ProductsApplication.products.name " + productCode );
            product.setCode(productCode);
            product.setDescription("DESCRIPTION_" + random.nextInt(1000000));
            product.setPrice(random.nextInt(1000000));
            product.setId(random.nextInt(1000000));
            products.add(product);
        }
        return products;
    }

}