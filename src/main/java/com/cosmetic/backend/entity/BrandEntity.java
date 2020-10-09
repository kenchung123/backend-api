package com.cosmetic.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "brand")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int brandId;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "logo")
    private String logo;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "brandEntity",cascade = CascadeType.ALL)
    private List<ProductEntity> listProducts = new ArrayList<>();
}
