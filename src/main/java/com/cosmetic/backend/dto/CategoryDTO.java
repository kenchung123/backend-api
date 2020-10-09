package com.cosmetic.backend.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private int categoryId;
    private String categoryName;
    private String categoryNameToSlug;
    private int groupCategoryId;
    private String groupCategoryName;

}
