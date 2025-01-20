package com.rapidsystems.shop_service.controllers;

import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(AdminController.URL)
@RequiredArgsConstructor
public class AdminController {

    public static final String URL = "/api/v1/admin";

    private final ProductService productService;

    @PostMapping(
            value = "/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductDto productDto) {
        ProductDto savedProduct = productService.saveProduct(productDto);
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping(
            value = "/products/{product_id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, String>> addProduct(@PathVariable(name = "product_id") UUID productId) {
        boolean deleteProduct = productService.deleteProduct(productId);
        return ResponseEntity.ok(
                Map.of("productId", productId.toString())
        );
    }

}

