package com.cosmetic.backend.repository;

import com.cosmetic.backend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
   List<ProductEntity> findByProductNameLikeIgnoreCaseOrBrandEntity_BrandNameLikeIgnoreCase(String productName, String brandName);
}
