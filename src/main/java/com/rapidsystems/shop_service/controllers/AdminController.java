package com.rapidsystems.shop_service.controllers;

import com.rapidsystems.shop_service.dto.PhotoDto;
import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.dto.ProductResponse;
import com.rapidsystems.shop_service.dto.UploadImageResponse;
import com.rapidsystems.shop_service.mapper.PhotoMapper;
import com.rapidsystems.shop_service.mapper.ProductResponseMapper;
import com.rapidsystems.shop_service.model.Photo;
import com.rapidsystems.shop_service.model.Product;
import com.rapidsystems.shop_service.service.product.data.ProductService;
import com.rapidsystems.shop_service.service.product.image.ProductImageUploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(AdminController.URL)
@RequiredArgsConstructor
public class AdminController {

    public static final String URL = "/api/v1/admin";

    private final ProductService productService;
    private final ProductImageUploadService productImageUploadService;
    private final ProductResponseMapper productResponseMapper;
    private final PhotoMapper photoMapper;

    @PostMapping(
            value = "/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProductResponse> addProduct(@RequestBody @Valid ProductDto productDto) {
        Product product = productService.saveProduct(productDto);
        ProductResponse productResponse = productResponseMapper.toProductResponse(product);
        return ResponseEntity.ok(productResponse);
    }

    @PostMapping(value = "/products/{productId}/images",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotoDto> uploadImages(@RequestParam("file") MultipartFile file,
                                                            @PathVariable String productId) {
        Photo photo = productImageUploadService.uploadImage(productId, file);
        PhotoDto photoDto = photoMapper.toDto(photo);
        return ResponseEntity.ok(photoDto);
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

