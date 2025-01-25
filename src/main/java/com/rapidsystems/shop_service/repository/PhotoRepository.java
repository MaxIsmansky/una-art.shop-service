package com.rapidsystems.shop_service.repository;

import com.rapidsystems.shop_service.model.Photo;
import com.rapidsystems.shop_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, UUID> {
}
