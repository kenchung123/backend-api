package com.cosmetic.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "groupcategory")
public class GroupCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupcategory_id")
    private int groupCategoryId;
    @Column(name = "groupcategory_name")
    private String groupCategoryName;
    @OneToMany(mappedBy = "groupCategoryEntity",fetch = FetchType.LAZY)
    private List<CategoryEntity> listCategorys = new ArrayList<>();
}
