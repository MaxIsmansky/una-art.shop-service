package com.rapidsystems.shop_service.service.product.data;

import com.rapidsystems.shop_service.dao.ProductDetailsDao;
import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.mapper.ProductMapper;
import com.rapidsystems.shop_service.mapper.ProductResponseMapper;
import com.rapidsystems.shop_service.model.Category;
import com.rapidsystems.shop_service.model.Product;
import jakarta.persistence.EntityManager;
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
    private final ProductResponseMapper productResponseMapper;
    private final EntityManager entityManager;

    @Override
    public Product findProduct(UUID id) {
        return productDetailsDao.findById(id);
    }

    @Override
    public List<Product> findAllInCategory(String categoryName) {
        return productDetailsDao.findAllInCategory(categoryName);
    }

    @Override
    public Product saveProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Category category = entityManager.getReference(Category.class, productDto.getCategoryUuid());
        product.setCategory(category);
        Product productEntity = productDetailsDao.save(product);
        return productEntity;
    }

    @Override
    public boolean deleteProduct(UUID uuid) {
        productDetailsDao.delete(uuid);
        return true;
    }
}
