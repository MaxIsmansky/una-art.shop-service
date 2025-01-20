package com.rapidsystems.shop_service.service;

import com.rapidsystems.shop_service.dao.ProductDetailsDao;
import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.mapper.ProductMapper;
import com.rapidsystems.shop_service.mapper.ProductMapperImpl;
import com.rapidsystems.shop_service.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Profile("!mock")
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDetailsDao productDetailsDao;
    private final ProductMapper productMapper;

    @Override
    public Product findProduct(UUID id) {
        return productDetailsDao.findById(id);
    }

    @Override
    public List<Product> findAllInCategory(String categoryName) {
        return productDetailsDao.findAllInCategory(categoryName);
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product productEntity = productDetailsDao.save(product);
        return productDto;
    }

    @Override
    public boolean deleteProduct(UUID uuid) {
        productDetailsDao.delete(uuid);
        return true;
    }
}
