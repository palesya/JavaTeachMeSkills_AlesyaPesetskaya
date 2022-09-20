package com.tms.springtoken.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenProvider {

    public static final String AUTH_KEY = "auth";

    @Value("svetbrkntiml;y8;lmrnb6jvr5thb4hrh55445h5h4j4e5svetbrkntiml;y8;lmrnb6jvr5thb4hrh55445h5h4j4e5svetbrkntiml;y8;lmrnb6jvr5thb4hrh55445h5h4j4e5svetbrkntiml;y8;lmrnb6jvr5thb4hrh55445h5h4j4e5svetbrkntiml;y8;lmrnb6jvr5thb4hrh55445h5h4j4e5svetbrkntiml;y8;lmrnb6jvr5thb4hrh554")
    private String secret;
    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(Authentication auth) {
        String username = auth.getPrincipal().toString();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        String collect = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        Date date = new Date(System.currentTimeMillis() + 900000000);
        return Jwts.builder()
                .setSubject(username)
                .claim(AUTH_KEY, collect)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                //.setExpiration(date)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claim = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        String auth = claim.get(AUTH_KEY).toString();
        String username = claim.getSubject();
        String[] split = auth.split(",");
        List<String> strings = Arrays.asList(split);
        List<SimpleGrantedAuthority> collect = strings.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(username, null, collect);
        return authToken;
    }

    public boolean isValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

}
