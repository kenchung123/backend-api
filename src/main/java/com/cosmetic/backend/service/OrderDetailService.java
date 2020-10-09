package com.cosmetic.backend.service;

import com.cosmetic.backend.dto.CartDTO;
import com.cosmetic.backend.dto.OrderDetailDTO;
import com.cosmetic.backend.dto.PaymentDTO;

import java.util.List;

public interface OrderDetailService {
 List<OrderDetailDTO> getAllOrderDetailByUserId();
  List<OrderDetailDTO> findAllByOrderDetailByOrderId(int orderId);
  OrderDetailDTO insertOrderDetail(OrderDetailDTO orderDetailDTO);
  void saveOrderDetail(PaymentDTO paymentDTO, int orderId);
}
