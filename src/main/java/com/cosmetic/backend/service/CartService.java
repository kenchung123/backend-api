package com.cosmetic.backend.service;

import com.cosmetic.backend.dto.CartDTO;
import com.cosmetic.backend.dto.OrderDetailDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> findAllCartByUserId(int userId);
    CartDTO findOneByCartId(int cartId);
    CartDTO updateQuantityCart(int cartID, long quantity);
    void deleteCart(int cartID);
    CartDTO addCart(int productID, long quantity);
    void deleteAllCart();
    List<CartDTO> findAllCartByProductIdAndUserId(int productId, int userId);
    boolean checkCartByUserIDAndProductId(int productId, int userId);

}
