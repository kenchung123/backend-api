package com.cosmetic.backend.repository;

import com.cosmetic.backend.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    OrderEntity findTop1ByOrderByOrderIdDesc();
  List<OrderEntity> findAllByUser_UserId(int userId);
    List<OrderEntity> findAllByOrderId(int orderId);


}
