package com.rapidsystems.shop_service.dao;

import com.rapidsystems.shop_service.model.Photo;
import com.rapidsystems.shop_service.repository.PhotoRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPhotoDao {

    private final PhotoRepository photoRepository;

    public void savePhoto(Photo photo) {
        photoRepository.save(photo);
    }

}
