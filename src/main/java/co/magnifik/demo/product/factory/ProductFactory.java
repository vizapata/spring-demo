package co.magnifik.demo.product.factory;

import co.magnifik.demo.product.model.Product;
import co.magnifik.demo.product.rest.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFactory {
    public static Product buildEntity(ProductDTO dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setId(dto.getId());
        product.setDescription(dto.getDescription());
        return product;
    }

    public static ProductDTO buildDTO(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setId(product.getId());
        dto.setDescription(product.getDescription());
        return dto;
    }

    public static List<ProductDTO> buildDTOs(List<Product> products) {
        return products
                .stream()
                .map(ProductFactory::buildDTO)
                .collect(Collectors.toList());
    }
}
