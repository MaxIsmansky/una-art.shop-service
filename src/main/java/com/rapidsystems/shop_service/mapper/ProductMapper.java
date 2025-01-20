package com.rapidsystems.shop_service.mapper;

import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.model.Category;
import com.rapidsystems.shop_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductMapper {

//    @Mapping(target = "category", source = "category", qualifiedByName = "categoryMapping")
    Product toEntity(ProductDto productDto);

//    @Named(value = "categoryMapping")
//    default Category toEntity(String category) {
//        return Category.builder().build();
//    };

}
