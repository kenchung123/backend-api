package com.cosmetic.backend.util;

import com.cosmetic.backend.dto.UserPrincipalDto;
import com.cosmetic.backend.exception.BadRequestException;
import com.cosmetic.backend.util.constant.MessageConstants;
import com.cosmetic.backend.validation.EMEnum;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.stream.Collectors;

public class SecurityUtil {

    public static UserPrincipalDto getUser() {
        if(!((SecurityContextHolder.getContext().getAuthentication()) instanceof AnonymousAuthenticationToken)) {
            UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)
                    SecurityContextHolder.getContext().getAuthentication();
            if (authentication.getPrincipal() instanceof UserPrincipalDto) {
                return (UserPrincipalDto) authentication.getPrincipal();
            }
        }
        else
            throw new com.cosmetic.backend.exception.AuthenticationException(MessageConstants.NOT_AUTHENTICATED);
        return null;
    }
    public static EMEnum.RoleName getRoleName(){
        EMEnum.RoleName roleName;
        try {
            String role =  Objects.requireNonNull(getUser()).getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining());
            roleName=EMEnum.RoleName.valueOf(role);
        }catch (IllegalArgumentException e){
            throw new BadRequestException(MessageConstants.ROLE_NOT_FOUND);
        }
        return roleName;

    }
}
