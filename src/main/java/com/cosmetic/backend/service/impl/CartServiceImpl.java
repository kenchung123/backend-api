package com.cosmetic.backend.service.impl;

import com.cosmetic.backend.dto.CartDTO;
import com.cosmetic.backend.dto.OrderDetailDTO;
import com.cosmetic.backend.entity.CartEntity;
import com.cosmetic.backend.mapper.*;
import com.cosmetic.backend.repository.CartRepository;
import com.cosmetic.backend.repository.OrderDetailRepository;
import com.cosmetic.backend.service.CartService;
import com.cosmetic.backend.service.ProductService;
import com.cosmetic.backend.service.UserService;
import com.cosmetic.backend.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<CartDTO> findAllCartByUserId(int userId) {
        return CartMapper.INSTANCE.toListCartDTO(cartRepository.findAllByUser_UserId(userId));
    }

    @Override
    public CartDTO findOneByCartId(int cartId) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
        return CartMapper.INSTANCE.toBCartDTO(cartEntity.get());
    }
//    @Override
//    public List<CartDTO> updateQuantityCart(int cartID, long quantity) {
//        Optional<CartEntity> cartEntity = cartRepository.findById(cartID);
//        if(quantity==0) {
//            productService.updateStatus(cartEntity.get().getProductEntity().getProductId());
//        }
//        cartEntity.get().setQuantity(quantity);
//        cartRepository.save(cartEntity.get());
//        return CartMapper.INSTANCE.toListCartDTO(cartEntity.get());
//    }
    @Override
    public CartDTO updateQuantityCart(int cartID, long quantity) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartID);
        if(quantity==0) {
           productService.updateStatus(cartEntity.get().getProductEntity().getProductId());
        }
        cartEntity.get().setQuantity(quantity);
        cartRepository.save(cartEntity.get());
        return CartMapper.INSTANCE.toBCartDTO(cartEntity.get());
    }

    @Override
    public void deleteCart(int cartID) {
        cartRepository.deleteById(cartID);
    }

    @Override
    public CartDTO addCart(int productID, long quantity) {
        CartEntity cartEntity = new CartEntity();
        if (checkCartByUserIDAndProductId(productID,SecurityUtil.getUser().getUserId()))
        {
            cartEntity = cartRepository.findByProductEntity_ProductIdAndUser_UserId(productID,SecurityUtil.getUser().getUserId());
            cartEntity.setQuantity(cartEntity.getQuantity()+quantity);
        }else{
            cartEntity.setQuantity(quantity);
            cartEntity.setProductEntity(ProductMapper.INSTANCE.toProductEntity(productService.getProductById(productID)));
            cartEntity.setUser(UserMapper.INSTANCE.toUserEntity(userService.getUserById(SecurityUtil.getUser().getUserId())));
        }
        return CartMapper.INSTANCE.toBCartDTO(cartRepository.save(cartEntity));
    }

    @Override
    public void deleteAllCart() {
        cartRepository.deleteAll();
    }

    @Override
    public List<CartDTO> findAllCartByProductIdAndUserId(int productId, int userId) {
        List<CartEntity> cartEntities = cartRepository.findAllByProductEntity_ProductIdAndUser_UserId(productId,userId);
        return CartMapper.INSTANCE.toListCartDTO(cartEntities);
    }

    @Override
    public boolean checkCartByUserIDAndProductId(int productId, int userId) {
        CartEntity cartEntity = cartRepository.findByProductEntity_ProductIdAndUser_UserId(productId,userId);
        if (cartEntity != null){
            return true;
        }
        return false;
    }

}
