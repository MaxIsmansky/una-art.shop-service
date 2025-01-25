package com.rapidsystems.shop_service.mapper;

import com.rapidsystems.shop_service.dto.PhotoDto;
import com.rapidsystems.shop_service.model.Photo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotoMapper {

    PhotoDto toDto(Photo photo);

}
