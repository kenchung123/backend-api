package com.cosmetic.backend.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ProductDTO {
    private int productId;
    private String productName;
    private Date createdDate;
    private String image;
    private long price;
    private long priceSale;
    private long quantity;
    private String status;
    private String productInfo;
    private String productDescription;
    private long discount;
    private String productNameToSlug;
    private int brandId;
    private String brandName;
    private int categoryId;
    private String categoryName;
}
