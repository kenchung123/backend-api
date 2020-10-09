package com.cosmetic.backend.service.impl;

import com.cosmetic.backend.dto.BrandDTO;
import com.cosmetic.backend.entity.BrandEntity;
import com.cosmetic.backend.exception.BadRequestException;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.mapper.BrandMapper;
import com.cosmetic.backend.repository.BrandRepository;
import com.cosmetic.backend.service.BrandService;
import com.cosmetic.backend.util.constant.MessageConstants;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Override
    public BrandDTO createBrand(BrandDTO brandDTO) {
            BrandEntity entity = brandRepository.save(BrandMapper.INSTANCE.toBrandEntity(brandDTO));
            return BrandMapper.INSTANCE.toBrandDTO(entity);
    }

    @Override
    public BrandDTO updateBrand( BrandDTO brandDTO) {
            BrandEntity entity = brandRepository.save(BrandMapper.INSTANCE.toBrandEntity(brandDTO));
            return BrandMapper.INSTANCE.toBrandDTO(entity);
    }

    @Override
    public List<BrandDTO> getAllBrand() {
        List<BrandEntity> entityList = brandRepository.findAll();
        return BrandMapper.INSTANCE.toListBrandDTO(entityList);
    }

    @Override
    public BrandDTO getBrandById( int brandId) {
        Optional<BrandEntity> brandEntity = brandRepository.findById(brandId);
        return BrandMapper.INSTANCE.toBrandDTO(brandEntity.get());
    }

    @Override
    public void deleteBrandById( int brandId) {
            Optional<BrandEntity> brandEntity = brandRepository.findById(brandId);
            if (brandEntity.isPresent()) {
                try {
                    brandRepository.deleteById(brandId);
                } catch (Exception e) {
                    throw new BadRequestException(MessageConstants.BRAND_CANNOT_DELETE);
                }
            } else throw new ResourceNotFoundException("Brand", "id", brandId);
    }



}
