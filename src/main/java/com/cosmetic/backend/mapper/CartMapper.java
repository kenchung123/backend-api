package com.cosmetic.backend.mapper;

import com.cosmetic.backend.dto.CartDTO;
import com.cosmetic.backend.entity.CartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
    @Mapping(source = "cartEntity.productEntity.productId",target = "productId")
    @Mapping(source = "cartEntity.productEntity.productName",target = "productName")
    @Mapping(source = "cartEntity.productEntity.image",target = "image")
    @Mapping(source = "cartEntity.productEntity.priceSale",target = "priceSale")
    CartDTO toBCartDTO(CartEntity cartEntity);
    List<CartDTO> toListCartDTO(List<CartEntity> cartEntities);
    @Mapping(source = "cartDTO.productId",target = "productEntity.productId")
    @Mapping(source = "cartDTO.productName",target = "productEntity.productName")
    @Mapping(source = "cartDTO.image",target = "productEntity.image")
    @Mapping(source = "cartDTO.priceSale",target = "productEntity.priceSale")
    CartEntity toCartEntity(CartDTO cartDTO);
    List<CartEntity> toListCartEntity( List<CartDTO> cartDTOS);
}
