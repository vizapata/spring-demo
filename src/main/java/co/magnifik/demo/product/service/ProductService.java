package co.magnifik.demo.product.service;

import co.magnifik.demo.product.factory.ProductFactory;
import co.magnifik.demo.product.model.Product;
import co.magnifik.demo.product.repository.ProductRepository;
import co.magnifik.demo.product.rest.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO create(ProductDTO productDTO) {
        Product product = ProductFactory.buildEntity(productDTO);
        productRepository.save(product);
        productDTO.setId(product.getId());
        return productDTO;
    }

    public ProductDTO get(Long id){
        Product product = productRepository.findById(id).orElseThrow();
        return ProductFactory.buildDTO(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public List<ProductDTO> list(String name){
        String nameLike = "%"+name+"%";
        List<Product> products = productRepository.findAllByNameLike(nameLike);
        return ProductFactory.buildDTOs(products);
    }
}
