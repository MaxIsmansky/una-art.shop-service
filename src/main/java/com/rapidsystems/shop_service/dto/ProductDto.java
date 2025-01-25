package com.rapidsystems.shop_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private UUID uuid;

    @JsonProperty(required = true)
    @NotBlank(message = "Product name cannot be blank")
    private String productName;

    @JsonProperty(required = true)
    @NotBlank(message = "Category cannot be blank")
    private UUID categoryUuid;

    private Integer creationYear;

    private String size;

    private String description;

    @JsonProperty(required = true)
    @NotNull(message = "Price cannot be blank")
    @Positive(message = "Price must be greater than 0")
    private Integer price;

    @JsonProperty(required = true)
    @NotBlank(message = "Currency cannot be blank")
    private String currency;

    private Integer maxAmount;

    private List<PhotoDto> photoDtoList;

}
