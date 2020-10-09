package com.cosmetic.backend.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id")
    private int productId;

    @Column(name ="product_name")
    private String productName;

    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate;

    @Column(name = "image")
    private String image;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "price")
    private long price;

    @Column(name = "price_sale")
    private long priceSale;

    @Column(name = "product_info")
    private String productInfo;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "discount")
    private long discount;

    @Column(name = "status")
    private String status;

    @Column(name = "product_name_to_slug")
    private String productNameToSlug;

   @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity")
    private List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();

    @OneToMany(mappedBy = "productEntity")
    private List<CartEntity> cartEntities = new ArrayList<>();

}
