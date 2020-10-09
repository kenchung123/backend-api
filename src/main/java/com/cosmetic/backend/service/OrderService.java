package com.cosmetic.backend.service;

import com.cosmetic.backend.dto.OrderDTO;
import com.cosmetic.backend.dto.OrderDetailDTO;
import com.cosmetic.backend.dto.PaymentDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrder();
    OrderDTO changeStatus(int orderId, int status, LocalDate dateUpdate);
    OrderDTO InsertOrder(List<PaymentDTO> paymentDTO);
//    List<OrderDTO> getOrderByUserId();
    List<OrderDTO> getOrder();
    void updateQuantityProduct(int productId, long quantity);
//    long totalPayment();
//    OrderDTO findByOrderIdMax();

}
