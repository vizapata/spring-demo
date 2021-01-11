package co.magnifik.demo.product.rest.controller;

import co.magnifik.demo.product.rest.dto.ProductDTO;
import co.magnifik.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(productService.create(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> list(@RequestParam("name") String name) {
        return ResponseEntity.ok(productService.list(name));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
