package com.cosmetic.backend.service.impl;

import com.cosmetic.backend.dto.CartDTO;
import com.cosmetic.backend.dto.OrderDetailDTO;
import com.cosmetic.backend.dto.PaymentDTO;
import com.cosmetic.backend.entity.OrderDetailEntity;
import com.cosmetic.backend.mapper.OrderDetailMapper;
import com.cosmetic.backend.repository.OrderDetailRepository;
import com.cosmetic.backend.service.OrderDetailService;
import com.cosmetic.backend.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

//    @Override
//    public List<PaymentDTO> getAllOrderDetailByUserId() {
//        List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.findAllByOrderEntity_User_UserId(SecurityUtil.getUser().getUserId());
//        return OrderDetailMapper.INSTANCE.toListOrderDetailDTO(orderDetailEntities);
//    }

    @Override
    public List<OrderDetailDTO> getAllOrderDetailByUserId() {
        List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.findAllByOrderEntity_User_UserId(SecurityUtil.getUser().getUserId());
        return OrderDetailMapper.INSTANCE.toListOrderDetailDTO(orderDetailEntities);
    }

    @Override
    public List<OrderDetailDTO> findAllByOrderDetailByOrderId(int orderId) {
        return OrderDetailMapper.INSTANCE.toListOrderDetailDTO(orderDetailRepository.findAllByOrderEntity_OrderId(orderId));
    }

    @Override
    public OrderDetailDTO insertOrderDetail(OrderDetailDTO orderDetailDTO) {
        OrderDetailEntity orderDetailEntity = orderDetailRepository.save(OrderDetailMapper.INSTANCE.toOrderDetailEntity(orderDetailDTO));
        return OrderDetailMapper.INSTANCE.toOrderDetailDTO(orderDetailEntity);
    }
    @Override
    public void saveOrderDetail(PaymentDTO paymentDTO, int orderId) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setOrderId(orderId);
        orderDetailDTO.setPrice(paymentDTO.getPriceSale());
        orderDetailDTO.setQuantity(paymentDTO.getQuantity());
        orderDetailDTO.setProductId(paymentDTO.getProductId());
        orderDetailRepository.save(OrderDetailMapper.INSTANCE.toOrderDetailEntity(orderDetailDTO));
    }

}
