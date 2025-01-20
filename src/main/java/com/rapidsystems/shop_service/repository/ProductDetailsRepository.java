package com.rapidsystems.shop_service.repository;

import com.rapidsystems.shop_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductDetailsRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByCategory_Name(String categoryId);

    @Modifying
    @Query(value = "DELETE FROM products p WHERE p.uuid = :uuid")
    void deleteByUuid(@Param("uuid") UUID uuid);

}
