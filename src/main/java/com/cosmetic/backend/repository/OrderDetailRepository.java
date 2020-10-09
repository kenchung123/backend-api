package com.cosmetic.backend.repository;

import com.cosmetic.backend.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Integer> {
   List<OrderDetailEntity> findAllByOrderEntity_OrderId(int orderId);
   List<OrderDetailEntity> findAllByOrderEntity_User_UserId(int userId);
   OrderDetailEntity findByProductEntity_ProductId(int productId);
//    List<OrderDetailEntity> findAllByGroupCategoryEntity_GroupCategoryId(int groupCategoryID);
}
