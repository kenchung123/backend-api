package com.cosmetic.backend.mapper;

import com.cosmetic.backend.dto.OrderDTO;
import com.cosmetic.backend.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OderMapper {
    OderMapper INSTANCE = Mappers.getMapper(OderMapper.class);
    @Mapping(source = "orderEntity.user.userId",target = "userId")
    @Mapping(source = "orderEntity.user.fullName",target = "fullName")
    OrderDTO toOrderDTO(OrderEntity orderEntity);
    List<OrderDTO> toListOrderDTO(List<OrderEntity> orderEntities);
    @Mapping(source = "orderDTO.userId",target = "user.userId")
    @Mapping(source = "orderDTO.fullName",target = "user.fullName")
    OrderEntity toOrderEntity(OrderDTO orderDTO);
    List<OrderEntity> toListOrderEntity( List<OrderDTO> orderDTOS);
}
