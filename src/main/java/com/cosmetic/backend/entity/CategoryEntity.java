package com.cosmetic.backend.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "categoy_name_to_slug")
    private String categoryNameToSlug;

//    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "groupcategory_id")
    private GroupCategoryEntity groupCategoryEntity;

    @OneToMany(mappedBy = "categoryEntity")
    private List<ProductEntity> listProducts = new ArrayList<>();


}
