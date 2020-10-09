package com.cosmetic.backend.mapper;

import com.cosmetic.backend.dto.BrandDTO;
import com.cosmetic.backend.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
    BrandDTO toBrandDTO(BrandEntity brandEntity);
    List<BrandDTO> toListBrandDTO(List<BrandEntity> brandEntities);
    BrandEntity toBrandEntity(BrandDTO brandDTO);
    List<BrandEntity> toListBrandEntity( List<BrandDTO> brandDTO);
}
