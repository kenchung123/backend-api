package com.cosmetic.backend.service.impl;

import com.cosmetic.backend.dto.CategoryDTO;
import com.cosmetic.backend.entity.CategoryEntity;
import com.cosmetic.backend.exception.BadRequestException;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.mapper.CategoryMapper;
import com.cosmetic.backend.repository.CategoryRepository;
import com.cosmetic.backend.service.CategoryService;
import com.cosmetic.backend.util.SecurityUtil;
import com.cosmetic.backend.util.constant.MessageConstants;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
            Slugify slg = new Slugify();
            categoryDTO.setCategoryNameToSlug(slg.slugify(categoryDTO.getCategoryName()));
            CategoryEntity categoryEntity = categoryRepository.save(CategoryMapper.INSTANCE.toCategoryEntity(categoryDTO));
            return CategoryMapper.INSTANCE.toCategoryDTO(categoryEntity);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
            CategoryEntity categoryEntity = categoryRepository.save(CategoryMapper.INSTANCE.toCategoryEntity(categoryDTO));
            return CategoryMapper.INSTANCE.toCategoryDTO(categoryEntity);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        return CategoryMapper.INSTANCE.toListCategoryDTO(categoryEntityList);
    }

    @Override
    public CategoryDTO getCategoryById(int categoryId) {
        Optional<CategoryEntity> categoryEntity =  categoryRepository.findById(categoryId);
        return CategoryMapper.INSTANCE.toCategoryDTO(categoryEntity.get());
    }

    @Override
    public void deleteCategoryById(int categoryId) {
       Optional<CategoryEntity> categoryEntity = categoryRepository.findById(categoryId);
        if(categoryEntity.isPresent()){
            try {
                categoryRepository.deleteById(categoryId);
            }catch (Exception e){
                throw new BadRequestException(MessageConstants.CATEGORY_CANNOT_DELETE);
            }
        }
        else throw new ResourceNotFoundException("Category", "id", categoryId);
    }
}
