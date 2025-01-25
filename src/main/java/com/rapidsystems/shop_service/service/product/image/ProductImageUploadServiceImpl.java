package com.rapidsystems.shop_service.service.product.image;

import com.rapidsystems.shop_service.dao.ProductDetailsDao;
import com.rapidsystems.shop_service.dao.ProductPhotoDao;
import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.dto.UploadImageResponse;
import com.rapidsystems.shop_service.model.Photo;
import com.rapidsystems.shop_service.model.Product;
import com.rapidsystems.shop_service.service.product.data.ProductService;
import com.rapidsystems.shop_service.service.s3.S3UploadService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductImageUploadServiceImpl implements ProductImageUploadService {

    private final S3UploadService s3UploadService;
    private final ProductPhotoDao productPhotoDao;
    private final ProductDetailsDao productDetailsDao;

    @Override
    @Transactional
    public Photo uploadImage(String productId, MultipartFile file) {
        String fileName = "image_" + file.getName() + "_" + productId;
        UploadImageResponse uploadImageResponse = s3UploadService.uploadFile("shop-data", fileName, file);

        Product product = productDetailsDao.findById(UUID.fromString(productId));

        Photo photo = Photo.builder()
                .url(uploadImageResponse.getUrl())
                .product(product)
                .isPreview(Boolean.FALSE)
                .build();

        product.getPhotoList().add(photo);

        productDetailsDao.save(product);

        return photo;
    }
}
