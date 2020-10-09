package com.cosmetic.backend.api;

import com.cosmetic.backend.dto.CartDTO;
import com.cosmetic.backend.dto.OrderDetailDTO;
import com.cosmetic.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/cart")
public class CartAPI {
    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    ResponseEntity<List<CartDTO>> getAllCartByUserId(@PathVariable("userId") int userId){
        return ResponseEntity.ok(cartService.findAllCartByUserId(userId));
    }
//    @GetMapping("/{cartId}")
//    ResponseEntity getCartById(@PathVariable("cartId") int cartId){
//        return ResponseEntity.ok(cartService.findOneByCartId(cartId));
//    }
    @PutMapping("{cartId}/{quantity}")
    ResponseEntity updateQuantityCart(@PathVariable("cartId")int cartId, @PathVariable("quantity")long quantity){
        return ResponseEntity.ok(cartService.updateQuantityCart(cartId,quantity));
    }
    @PostMapping("{productId}/{quantity}")
    ResponseEntity addCart(@PathVariable("productId") int productId,@PathVariable("quantity") long quantity){
        return ResponseEntity.ok(cartService.addCart(productId,quantity));
    }
    @DeleteMapping("/{cardId}")
    ResponseEntity<?> deleteCartById( @PathVariable("cardId") int cartId){
        cartService.deleteCart(cartId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping
    ResponseEntity<?> deleteAllCart(){
        cartService.deleteAllCart();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
