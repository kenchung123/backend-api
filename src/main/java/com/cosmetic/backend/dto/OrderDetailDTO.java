package com.cosmetic.backend.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDetailDTO {
    private int orderDetailId;
    private Long quantity;
    private Long price;
    private String image;
    private int productId;
    private Integer status;
    private String productName;
    @NotNull
    private String paymentMethods;
    private int orderId;
    private Long total;
    public Long getTotal() {
        return (this.quantity * this.price);
    }
}
