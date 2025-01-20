package com.rapidsystems.shop_service.controllers;

import com.rapidsystems.shop_service.model.Product;
import com.rapidsystems.shop_service.service.ProductService;
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

    @GetMapping("/{category}/{id}")
    public ResponseEntity<Product> productDetails(@PathVariable String category,
                                                  @PathVariable UUID id) {
        Product product = productService.findProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Product>> categoryProducts(@PathVariable String category) {
        List<Product> productList = productService.findAllInCategory(category);
        return ResponseEntity.ok(productList);
    }

}
