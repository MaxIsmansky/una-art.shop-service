package com.rapidsystems.shop_service.controllers;

import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.mapper.ProductMapper;
import com.rapidsystems.shop_service.model.Product;
import com.rapidsystems.shop_service.service.product.data.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ProductController.URL)
@RequiredArgsConstructor
public class ProductController {

    public static final String URL = "/api/v1/shop";

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/{category}/{id}")
    public ResponseEntity<ProductDto> productDetails(@PathVariable String category,
                                                  @PathVariable UUID id) {
        Product product = productService.findProduct(id);
        ProductDto productDto = productMapper.toDto(product);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<ProductDto>> categoryProducts(@PathVariable String category) {
        List<Product> productList = productService.findAllInCategory(category);
        List<ProductDto> productDtoList = productMapper.toDtoList(productList);
        return ResponseEntity.ok(productDtoList);
    }

}
