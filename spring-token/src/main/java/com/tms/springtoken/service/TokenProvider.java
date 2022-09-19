package com.tms.springtoken.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
public class TokenProvider {

    public static final String AUTH_KEY = "auth";

    @Value("${spring.security.token.key}")
    private String secret;
    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(Authentication auth) {
        String username = auth.getPrincipal().toString();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        Date date = new Date(System.currentTimeMillis() + 900000000);
        return Jwts.builder()
                .setSubject(username)
                .claim(AUTH_KEY, authorities)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .setExpiration(date)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claim = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJwt(token)
                .getBody();
        String auth = claim.get(AUTH_KEY).toString();
        String username = claim.getSubject();
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(username, null, List.of(() -> auth));
        return authToken;
    }

    public boolean isValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJwt(token);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

}
