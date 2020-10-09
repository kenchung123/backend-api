package com.cosmetic.backend.mapper;

import com.cosmetic.backend.dto.CategoryDTO;
import com.cosmetic.backend.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    @Mapping(source = "categoryEntity.groupCategoryEntity.groupCategoryId",target = "groupCategoryId")
   @Mapping(source = "categoryEntity.groupCategoryEntity.groupCategoryName",target = "groupCategoryName")
    CategoryDTO toCategoryDTO(CategoryEntity categoryEntity);
    List<CategoryDTO> toListCategoryDTO(List<CategoryEntity> categoryEntityList);
    @Mapping(source = "categoryDTO.groupCategoryId",target = "groupCategoryEntity.groupCategoryId")
   @Mapping(source = "categoryDTO.groupCategoryName",target = "groupCategoryEntity.groupCategoryName")
    CategoryEntity toCategoryEntity(CategoryDTO categoryDTO);
    List<CategoryEntity> toListCategoryEntity( List<CategoryDTO> categoryDTOList);
}
