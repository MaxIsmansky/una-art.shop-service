package com.rapidsystems.shop_service.service.product.image;

import com.rapidsystems.shop_service.model.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface ProductImageUploadService {

    Photo uploadImage(String productId, MultipartFile file);

}
