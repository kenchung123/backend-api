package com.cosmetic.backend.dto;

import com.cosmetic.backend.entity.User;
import lombok.Data;
import lombok.val;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
public class UserPrincipalDto implements UserDetails {
    private int userId;
    private String fullName;
    private String password;
    private String email;
    private int enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipalDto create(User user) {
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getRoleName().name()));

        return new UserPrincipalDto(
                user.getUserId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.getEnabled(),
                authorities
        );
    }
    public UserPrincipalDto(Integer userId, String fullName, String email, String password, Integer enabled, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        this.enabled =1;
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
