package com.cosmetic.backend.dto;

import lombok.Data;

import javax.validation.constraints.Email;


@Data
public class ResetPasswordParam {
    @Email
    private String Email;
}
