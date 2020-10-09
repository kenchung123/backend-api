package com.cosmetic.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PaymentDTO {
    private int cartId;
    private int productId;
    private long quantity;
    private long priceSale;
    @NotNull(message = "payment not null")
    private String payment;
    private long total;
    public long getTotal() {
       return (this.quantity * this.priceSale);
   }
}
