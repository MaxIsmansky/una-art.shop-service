package com.rapidsystems.shop_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "product_images")
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "is_preview", nullable = false)
    private Boolean isPreview;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}