package com.rapidsystems.shop_service.mapper;

import com.rapidsystems.shop_service.dto.ProductResponse;
import com.rapidsystems.shop_service.model.Category;
import com.rapidsystems.shop_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    @Mapping(target = "categoryName", source = "category", qualifiedByName = "categoryMapping")
    ProductResponse toProductResponse(Product product);

    @Named(value = "categoryMapping")
    default String toEntity(Category category) {
        return category.getName();
    };

}
