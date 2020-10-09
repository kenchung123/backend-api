package com.cosmetic.backend.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Date;

@Data
public class UserDTO {
    private int userId;
    @NotNull(message = "full name can not empty")
    private String fullName;
    @NotNull(message = "password can not empty")
    private String password;
    @Pattern(regexp = "^(09|07|03|08|05)\\d{8}$")
    private String phoneNumber;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date of birth is not null")
    private Date birthDate;
    @Email(message = "email wrong")
    private String email;
    private String gender;
    private String address;
    private String imageProfile;
    private int roleId;
}
