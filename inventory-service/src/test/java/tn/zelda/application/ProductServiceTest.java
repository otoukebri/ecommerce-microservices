package tn.zelda.application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tn.zelda.domain.Product;
import tn.zelda.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductBusiness productBusiness;

    @MockBean
    ProductRepository productRepository;

    List<Product> mockProducts;

    @Before
    public void iniTest() {
        mockProducts =  Arrays.asList(
                new Product(1L, "Nexus5","e", 350),
                new Product(2L,"Nokia3310","r", 10)
        );

        Mockito.when(productRepository.findAll()).thenReturn(mockProducts);
    }

    @Test
    public void getProductsNonEmptyResultTest() {
        assertEquals(mockProducts, productBusiness.getProducts());
    }
}
