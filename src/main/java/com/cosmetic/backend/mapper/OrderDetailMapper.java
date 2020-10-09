package com.cosmetic.backend.mapper;

import com.cosmetic.backend.dto.OrderDetailDTO;
import com.cosmetic.backend.entity.OrderDetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
    @Mappings({
            @Mapping(source = "orderDetailEntity.productEntity.productId",target = "productId"),
            @Mapping(source = "orderDetailEntity.productEntity.productName",target = "productName"),
            @Mapping(source = "orderDetailEntity.orderEntity.orderId",target = "orderId"),
            @Mapping(source = "orderDetailEntity.orderEntity.status",target = "status"),
            @Mapping(source = "orderDetailEntity.orderEntity.paymentMethods",target = "paymentMethods"),
            @Mapping(source = "orderDetailEntity.productEntity.image",target = "image")
    })
    OrderDetailDTO toOrderDetailDTO(OrderDetailEntity orderDetailEntity);
    List<OrderDetailDTO> toListOrderDetailDTO(List<OrderDetailEntity> orderDetailEntities);
    @Mappings({
            @Mapping(source = "orderDetailDTO.productId",target = "productEntity.productId"),
//          @Mapping(source = "orderDetailDTO.productName",target = "productEntity.productName"),
            @Mapping(source = "orderDetailDTO.orderId",target = "orderEntity.orderId"),
            @Mapping(source = "orderDetailDTO.status",target = "orderEntity.status"),
            @Mapping(source = "orderDetailDTO.paymentMethods",target = "orderEntity.paymentMethods"),
//       @Mapping(source = "orderDetailDTO.image",target = "productEntity.image")
    })
    OrderDetailEntity toOrderDetailEntity(OrderDetailDTO orderDetailDTO);
    List<OrderDetailEntity> toListOrderDetailEntity( List<OrderDetailDTO> orderDetailDTOS);
}
