package com.cosmetic.backend.service.impl;

import com.cosmetic.backend.dto.BrandDTO;
import com.cosmetic.backend.dto.ProductDTO;
import com.cosmetic.backend.entity.ProductEntity;
import com.cosmetic.backend.exception.BadRequestException;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.mapper.ProductMapper;
import com.cosmetic.backend.repository.BrandRepository;
import com.cosmetic.backend.repository.ProductRepository;
import com.cosmetic.backend.service.BrandService;
import com.cosmetic.backend.service.ProductService;
import com.cosmetic.backend.util.constant.MessageConstants;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
            Slugify slg = new Slugify();
            productDTO.setProductNameToSlug(slg.slugify(productDTO.getProductName()));
            ProductEntity entity = productRepository.save(ProductMapper.INSTANCE.toProductEntity(productDTO));
            return ProductMapper.INSTANCE.toProductDTO(entity);
        }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
            ProductEntity entity = productRepository.save(ProductMapper.INSTANCE.toProductEntity(productDTO));
            return ProductMapper.INSTANCE.toProductDTO(entity);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductEntity> entity = productRepository.findAll();
        return ProductMapper.INSTANCE.toListProductDTO(entity);
    }

    @Override
    public ProductDTO getProductById(int productId) {
        Optional<ProductEntity> entity = productRepository.findById(productId);
        return ProductMapper.INSTANCE.toProductDTO(entity.get());
    }

    @Override
    public void deleteProduct(int productId) {
        Optional<ProductEntity> entity = productRepository.findById(productId);
        if (entity.isPresent()){
            try {
                productRepository.deleteById(productId);
            }catch (Exception e){
                throw new BadRequestException(MessageConstants.PRODUCT_CANNOT_DELETE);
            }
        }else {
            throw new ResourceNotFoundException("Product", "id", productId);
        }
    }

    @Override
    public ProductDTO updateStatus(int productId) {
        Optional<ProductEntity> productEntity = productRepository.findById(productId);
        productEntity.get().setStatus("Hết hàng");
        return ProductMapper.INSTANCE.toProductDTO(productEntity.get());
    }

    @Override
    public List<ProductDTO> findAllProduct( String keySearch) {
        List<ProductEntity> productEntities = productRepository.findByProductNameLikeIgnoreCaseOrBrandEntity_BrandNameLikeIgnoreCase("%"+keySearch+"%","%"+keySearch+"%");
        return ProductMapper.INSTANCE.toListProductDTO(productEntities);
    }

    @Override
    public int updateQuantityProduct(int productId, long quantity) {
        Optional<ProductEntity> productEntity = productRepository.findById(productId);
        long soLuong =  productEntity.get().getQuantity()-quantity;
        if(soLuong<0){
            return 0;// k đủ sô lượng sản phẩm
        }else if(soLuong==0){
            productEntity.get().setStatus("Hêt hàng");
            productEntity.get().setQuantity(soLuong);
        }else{
            productEntity.get().setQuantity(soLuong);
        }
        productRepository.save(productEntity.get());
        return 1;
    }
}
