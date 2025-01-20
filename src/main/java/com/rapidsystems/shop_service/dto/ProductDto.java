package com.rapidsystems.shop_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @JsonProperty(required = true)
    @NotBlank(message = "Product name cannot be blank")
    private String productName;

//    private String category;

    private Integer creationYear;

    private String size;

    private String description;

    private Integer price;

    private String currency;

    private Integer maxAmount;

//    private List<String> photoIdList;

}
