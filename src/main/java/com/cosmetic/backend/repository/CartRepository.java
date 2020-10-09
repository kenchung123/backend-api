package com.cosmetic.backend.repository;

import com.cosmetic.backend.entity.CartEntity;
import com.cosmetic.backend.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Integer> {
    List<CartEntity> findAllByUser_UserId(int userId);
    List<CartEntity> findAllByProductEntity_ProductIdAndUser_UserId(int productId, int userId);
    CartEntity findByProductEntity_ProductIdAndUser_UserId(int productId, int userId);
}
