package co.magnifik.demo.product;

import co.magnifik.demo.product.rest.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductApplicationTests {

    @Autowired
    private ProductController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
