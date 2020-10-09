package com.cosmetic.backend.dto;

import com.cosmetic.backend.validation.EMEnum;
import lombok.Data;

import java.util.List;

@Data
public class JwtAuthenticationStatusDto {
    private String accessToken;
    private String tokenType = "Bearer";
    private EMEnum.RoleName roleName;

    public JwtAuthenticationStatusDto(String accessToken, EMEnum.RoleName roleName) {
        this.accessToken = accessToken;
        this.roleName = roleName;
    }
}
