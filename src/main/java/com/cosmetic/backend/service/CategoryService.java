package com.cosmetic.backend.service;

import com.cosmetic.backend.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategory();
    CategoryDTO getCategoryById(int categoryId);
    void deleteCategoryById(int categoryId);
}
