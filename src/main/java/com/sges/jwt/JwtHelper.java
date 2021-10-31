package com.sges.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sges.dto.CustomUserDetail;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtHelper {

    private final String JWT_SECRET = "sapoooooo";

    private final long JWT_EXPIRATION = 604800000L;

    public String generateTJwtToken(CustomUserDetail customUserDetail) throws JsonProcessingException {
        Date now = new Date();
        Date exp = new Date(now.getTime() + JWT_EXPIRATION);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(customUserDetail.getUser());
        return Jwts.builder()
                .setSubject(customUserDetail.getUsername())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .claim("user", json)
                .compact();
    }

    public String getClaim(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(jwtToken)
                .getBody().get("user", String.class);
    }

    public String getUsernameFromJwt(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(jwtToken)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(jwtToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

}
