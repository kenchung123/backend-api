package com.cosmetic.backend.api;

import com.cosmetic.backend.dto.OrderDetailDTO;
import com.cosmetic.backend.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orderdetail")
public class OrderDetailApi {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/get-order-detail-by-userId")
    public ResponseEntity<List<OrderDetailDTO>> getAllOrderDetailByUserId(){
        return ResponseEntity.status(HttpStatus.OK).body(orderDetailService.getAllOrderDetailByUserId());
    }
    @GetMapping("/{orderId}")
    ResponseEntity<List<OrderDetailDTO>> getAllOrderDetailByOrderId(@PathVariable("orderId") int orderId){
        return ResponseEntity.ok(orderDetailService.findAllByOrderDetailByOrderId(orderId));
    }
    @PostMapping
    public ResponseEntity<?> insertOrder(OrderDetailDTO orderDetailDTO){
        return ResponseEntity.status(HttpStatus.OK).body(orderDetailService.insertOrderDetail(orderDetailDTO));
    }
}
