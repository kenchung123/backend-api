package com.cosmetic.backend.service;

import com.cosmetic.backend.dto.ProductDTO;
import com.cosmetic.backend.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProduct();
    ProductDTO getProductById(int productId);
    void deleteProduct(int productId);
    ProductDTO updateStatus(int productId);
   List<ProductDTO> findAllProduct( String keySearch);
   int updateQuantityProduct(int productId, long quantity);
}
