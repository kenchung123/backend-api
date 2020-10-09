package com.cosmetic.backend.mapper;

import com.cosmetic.backend.dto.ProductDTO;
import com.cosmetic.backend.entity.ProductEntity;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mappings({
            @Mapping(source = "productEntity.categoryEntity.categoryId",target = "categoryId"),
            @Mapping(source = "productEntity.categoryEntity.categoryName",target = "categoryName"),
            @Mapping(source = "productEntity.brandEntity.brandId",target = "brandId"),
            @Mapping(source = "productEntity.brandEntity.brandName",target = "brandName"),
    })
    ProductDTO toProductDTO(ProductEntity productEntity);

    List<ProductDTO> toListProductDTO(List<ProductEntity> productEntityList);
    @Mappings({
            @Mapping(source = "productDTO.categoryId",target = "categoryEntity.categoryId"),
            @Mapping(source = "productDTO.categoryName",target = "categoryEntity.categoryName"),
            @Mapping(source = "productDTO.brandId",target = "brandEntity.brandId"),
            @Mapping(source = "productDTO.brandName",target = "brandEntity.brandName"),
    })
    ProductEntity toProductEntity(ProductDTO productDTO);

    List<ProductEntity> toListProductEntity( List<ProductDTO> productDTOList);
}
