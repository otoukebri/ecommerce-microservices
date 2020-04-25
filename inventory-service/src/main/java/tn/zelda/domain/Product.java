package tn.zelda.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product", type = "product")
@Data
public class Product {
    @Id
    private long id;
    private String code;
    private String lable;
    private float price;
    private String description;

    public Product() {
    }
}
