package com.rapidsystems.shop_service.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter // Add this if setters are needed for modification
@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @UuidGenerator
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "creation_year")
    private Integer creationYear;

    @Column(name = "size")
    private String size;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "max_amount")
    private Integer maxAmount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photoList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "preview_photo_id")
    private Photo previewPhoto;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}