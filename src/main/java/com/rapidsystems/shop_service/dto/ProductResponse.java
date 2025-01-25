package com.rapidsystems.shop_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductResponse {

    private UUID uuid;
    private String productName;
    private String categoryName;
    private List<String> imageIdsList;

}
