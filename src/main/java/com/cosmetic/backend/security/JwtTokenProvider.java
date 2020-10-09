package com.cosmetic.backend.security;

import com.cosmetic.backend.dto.UserPrincipalDto;
import com.cosmetic.backend.util.constant.MessageConstants;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("JWTSupperSecretKey")
    private String jwtSecret;

    @Value("60480000")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {

        UserPrincipalDto userPrincipal = (UserPrincipalDto) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getUserId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Integer getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return Integer.parseInt(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            log.error(MessageConstants.INVALID_JWT_SIGNATURE);
        } catch (MalformedJwtException ex) {
            log.error(MessageConstants.INVALID_JWT_TOKEN);
        } catch (ExpiredJwtException ex) {
            log.error(MessageConstants.EXPIRED_JWT_TOKEN);
        } catch (UnsupportedJwtException ex) {
            log.error(MessageConstants.UNSUPORT_JWT_TOKEN);
        } catch (IllegalArgumentException ex) {
            log.error(MessageConstants.JWT_CLAIMS_EMPTY);
        }
        return false;
    }
}
