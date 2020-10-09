package com.cosmetic.backend.service.impl;

import com.cosmetic.backend.dto.CartDTO;
import com.cosmetic.backend.dto.OrderDTO;
import com.cosmetic.backend.dto.OrderDetailDTO;
import com.cosmetic.backend.dto.PaymentDTO;
import com.cosmetic.backend.entity.*;
import com.cosmetic.backend.mapper.CartMapper;
import com.cosmetic.backend.mapper.OderMapper;
import com.cosmetic.backend.mapper.UserMapper;
import com.cosmetic.backend.repository.*;
import com.cosmetic.backend.service.*;
import com.cosmetic.backend.util.SecurityUtil;
import org.hibernate.type.OrderedMapType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderDetailService orderDetailService;
    @Override
    public List<OrderDTO> getAllOrder() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return OderMapper.INSTANCE.toListOrderDTO(orderEntities);
    }

    @Override
    public OrderDTO changeStatus(int orderId, int status, LocalDate dateUpdate) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        if(status == 2){
            List<OrderDetailDTO> orderDetailDTO = orderDetailService.findAllByOrderDetailByOrderId(orderId);
            for(OrderDetailDTO orderDetailDTO1 : orderDetailDTO) {
                productService.updateQuantityProduct(orderDetailDTO1.getProductId(),orderDetailDTO1.getQuantity());
            }
        }
        orderEntity.get().setStatus(status);
        orderEntity.get().setCreatedDate(LocalDate.now());
        orderRepository.save(orderEntity.get());
        return OderMapper.INSTANCE.toOrderDTO(orderEntity.get());
    }

//    @Override
//    public OrderDTO InsertOrder(OrderDTO orderDTO) {
//        OrderEntity orderEntity = new OrderEntity();olollkjjg
//        orderEntity.setStatus(1);
//        orderEntity.setUser();
//        orderEntity.setCreatedDate(LocalDate.now());
//        orderRepository.save(orderEntity);
//        return OderMapper.INSTANCE.toOrderDTO(orderEntity);
//    }

    @Override
    public OrderDTO InsertOrder(List<PaymentDTO> paymentDTO) {
        OrderEntity orderEntity = new OrderEntity();
      orderEntity.setPaymentMethods(paymentDTO.get(0).getPayment());
        orderEntity.setStatus(1);
        orderEntity.setCreatedDate(LocalDate.now());
        orderEntity.setUser(UserMapper.INSTANCE.toUserEntity(userService.getUserById(SecurityUtil.getUser().getUserId())));
        orderRepository.save(orderEntity);
        OrderDTO orderDTO = OderMapper.INSTANCE.toOrderDTO(orderEntity);
        int orderID = orderRepository.findTop1ByOrderByOrderIdDesc().getOrderId();
        for (PaymentDTO payment: paymentDTO){
            orderDetailService.saveOrderDetail(payment,orderID);
            cartService.deleteCart(payment.getCartId());
        }

        return OderMapper.INSTANCE.toOrderDTO(orderEntity);
    }

//    @Override
//    public List<OrderDTO> getOrderByUserId() {
//        List<OrderEntity> orderEntities = orderRepository.findAllByUser_UserId(SecurityUtil.getUser().getUserId());
//        return null;
//    }

    @Override
    public List<OrderDTO> getOrder() {
        List<OrderDTO> orderDTOS = new ArrayList<OrderDTO>();
        List<OrderEntity> orderEntities = orderRepository.findAllByUser_UserId(SecurityUtil.getUser().getUserId());
        for (OrderEntity orderEntity :orderEntities){
            List<OrderDetailDTO> orderDetailDTOS = orderDetailService.findAllByOrderDetailByOrderId(orderEntity.getOrderId());
            long totalPayment = 0;
            OrderDTO orderDTO = OderMapper.INSTANCE.toOrderDTO(orderEntity);
          for(OrderDetailDTO ordetailDTO : orderDetailDTOS ){
                totalPayment += ordetailDTO.getTotal()+30000;
            }
            orderDTO.setTotalPayment(totalPayment);
            orderDTO.setOrderDetailDTOS(orderDetailDTOS);
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public void updateQuantityProduct(int productId, long quantity) {
//
    }

//    @Override
//    public long totalPayment() {
//        List<>
//        return 0;
//    }


//    @Override
//    public OrderDTO findByOrderIdMax() {
//        return OderMapper.INSTANCE.toOrderDTO(orderRepository.findTop1ByOrderByOrderIdDesc());
//    }

}
