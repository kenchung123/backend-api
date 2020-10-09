package com.cosmetic.backend.dto;

import lombok.Data;

@Data
public class BrandDTO {
    private int brandId;
    private String brandName;
    private String logo;
    private String description;
}
