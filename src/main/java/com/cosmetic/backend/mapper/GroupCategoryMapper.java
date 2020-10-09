package com.cosmetic.backend.mapper;

import com.cosmetic.backend.dto.GroupCategoryDTO;
import com.cosmetic.backend.entity.GroupCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GroupCategoryMapper {
    GroupCategoryMapper INSTANCE = Mappers.getMapper(GroupCategoryMapper.class);

    GroupCategoryDTO toGroupCategoryDTO(GroupCategoryEntity groupCategoryEntity);
    List<GroupCategoryDTO> toListGroupCategoryDTO(List<GroupCategoryEntity> groupCategoryEntityList);
    GroupCategoryEntity toGroupCategoryEntity(GroupCategoryDTO groupCategoryDTO);
    List<GroupCategoryEntity> toListGroupCategoryEntity( List<GroupCategoryDTO> groupCategoryDTOList);
}
