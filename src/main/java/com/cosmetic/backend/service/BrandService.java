package com.cosmetic.backend.service;

import com.cosmetic.backend.dto.BrandDTO;
import com.cosmetic.backend.entity.BrandEntity;

import java.util.List;

public interface BrandService {
    BrandDTO createBrand(BrandDTO brandDTO);
    BrandDTO updateBrand(BrandDTO brandDTO);
    List<BrandDTO> getAllBrand();
    BrandDTO getBrandById(int brandId);
    void deleteBrandById(int brandId);
//    BrandDTO findByBrandName(String brandName);

}
