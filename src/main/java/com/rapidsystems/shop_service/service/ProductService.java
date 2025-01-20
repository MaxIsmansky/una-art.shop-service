package com.rapidsystems.shop_service.service;

import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.model.Product;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product findProduct(UUID id);

    List<Product> findAllInCategory(String category);

    ProductDto saveProduct(ProductDto productDto);

    boolean deleteProduct(UUID uuid);

}
