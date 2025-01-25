package com.rapidsystems.shop_service.mapper;

import com.rapidsystems.shop_service.dto.ProductDto;
import com.rapidsystems.shop_service.model.Category;
import com.rapidsystems.shop_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "photoDtoList", target = "photoList")
    Product toEntity(ProductDto productDto);

    @Mapping(source = "photoList", target = "photoDtoList")
    ProductDto toDto(Product product);

    @Mapping(source = "photoDtoList", target = "photoList")
    List<Product> toEntityList(List<ProductDto> productDtoList);

    @Mapping(source = "photoList", target = "photoDtoList")
    List<ProductDto> toDtoList(List<Product> productList);

}
