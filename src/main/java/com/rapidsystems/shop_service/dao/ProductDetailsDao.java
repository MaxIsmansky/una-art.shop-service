package com.rapidsystems.shop_service.dao;

import com.rapidsystems.shop_service.model.Product;
import com.rapidsystems.shop_service.repository.ProductDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductDetailsDao {

    private final ProductDetailsRepository productDetailsRepository;

    public List<Product> findAll() {
        return null;
    }

    public List<Product> findAll(String category) {
        return null;
    }

    public Product findById(final UUID id) {
        return productDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with id %s not found!", id)));
    }

    public List<Product> findAllInCategory(String categoryName) {
        return productDetailsRepository.findAllByCategory_Name(categoryName);
    }

    public Product save(Product product) {
        return productDetailsRepository.save(product);
    }

    @Transactional
    public void delete(UUID uuid) {
        productDetailsRepository.deleteByUuid(uuid);
    }

}
