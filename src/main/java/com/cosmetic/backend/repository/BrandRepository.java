package com.cosmetic.backend.repository;

import com.cosmetic.backend.dto.BrandDTO;
import com.cosmetic.backend.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
// @Query("select b from BrandEntity b where b.brandName = ?1")
 BrandEntity findOneByBrandName(String brandName);
}
