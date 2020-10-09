package com.cosmetic.backend.api;

import com.cosmetic.backend.dto.OrderDTO;
import com.cosmetic.backend.dto.PaymentDTO;
import com.cosmetic.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/get-order-by-user")
    public ResponseEntity<List<OrderDTO>> getOrder(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder());
    }
@PutMapping("{id}/{status}")
public ResponseEntity<?> changeStatus(@PathVariable("id") int orderId, @PathVariable("status") int status, LocalDate dateUpdate){
    return ResponseEntity.status(HttpStatus.OK).body(orderService.changeStatus(orderId,status,dateUpdate));
}
    @PostMapping
    public ResponseEntity<?> insertOrder(@RequestBody List<PaymentDTO> paymentDTO){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.InsertOrder(paymentDTO));
    }
}
