package com.cosmetic.backend.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class ChangePasswordParam {
    @Email
    private String email;
    private String oldPassword;
    private String newPassword;
}
