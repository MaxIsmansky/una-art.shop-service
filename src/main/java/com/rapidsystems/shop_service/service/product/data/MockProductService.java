package com.rapidsystems.shop_service.service.product.data;

import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.model.Photo;
import com.rapidsystems.shop_service.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@Profile("mock")
public class MockProductService implements ProductService {

    @Override
    public Product findProduct(UUID id) {
        return Product.builder()
                .uuid(UUID.randomUUID())
                .productName("Картина \"Закат\"")
                .creationYear(2023)
                .price(5600)
                .description("Картина с закатом на ней")
                .maxAmount(1)
                .currency("Руб")
                .size("1000x1000")
                .photoList(
                        List.of(
                                Photo.builder()
                                        .uuid(UUID.randomUUID())
                                        .url("http://192.168.1.72:9090/api/v1/download-shared-object/aHR0cDovLzEyNy4wLjAuMTo5MDAwL3VuYS1hcnQtZGV2L3Byb2R1Y3RzLzIwMjQtMTItMjQlMjAxOS4yNy41OS5qcGc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1KUUlPVERMUkVOSzAyWFcwRjhPUSUyRjIwMjQxMjI0JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MTIyNFQxNjI5MzdaJlgtQW16LUV4cGlyZXM9MzU5OTkmWC1BbXotU2VjdXJpdHktVG9rZW49ZXlKaGJHY2lPaUpJVXpVeE1pSXNJblI1Y0NJNklrcFhWQ0o5LmV5SmhZMk5sYzNOTFpYa2lPaUpLVVVsUFZFUk1Va1ZPU3pBeVdGY3dSamhQVVNJc0ltVjRjQ0k2TVRjek5URXdNRGN5TVN3aWNHRnlaVzUwSWpvaVlXUnRhVzRpZlEuRE5xMEwySGJ2WHpOQy1KZldNWXl3Z2MxMGxBd0RueGVRY21vY2VwY2NpMXVkcmt3ZFdpNzRwOEVVQWRqWlluOVVMd0sxcDdBd1ZvTF9pYnFZcEpTUncmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JnZlcnNpb25JZD1udWxsJlgtQW16LVNpZ25hdHVyZT05Y2ViYTdiZTFlYzg1ZmJlOTFmNzc0NGE0ZjRjOWI4NGRjMjU0NjBjMzA5MjkzYzVjZDA4YzA2ODNlZmNmNjdh")
                                        .build()
                        )
                )
                .build();
    }

    @Override
    public List<Product> findAllInCategory(String category) {
        return List.of(
                findProduct(UUID.randomUUID()),
                findProduct(UUID.randomUUID())
        );
    }

    @Override
    public Product saveProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public boolean deleteProduct(UUID uuid) {
        return false;
    }
}
