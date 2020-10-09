package com.cosmetic.backend.dto;

import lombok.Data;

@Data
public class CartDTO {
    private int cartId;
    private String productName;
    private int productId;
    private String image;
    private long quantity;
    private long priceSale;
    private long total;
    public long getTotal() {
        return this.quantity * this.priceSale;
    }
}
