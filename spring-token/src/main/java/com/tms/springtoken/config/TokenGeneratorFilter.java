package com.tms.springtoken.config;

import com.tms.springtoken.service.TokenProvider;
import com.tms.springtoken.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TokenGeneratorFilter extends OncePerRequestFilter {

    private final UserService service;
    @Autowired
    private TokenProvider provider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getParameter("username");
        UserDetails userDetails = service.getByUsername(username);

        if (userDetails != null) {
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(userDetails.getUsername(), "", userDetails.getAuthorities());
            String token = provider.createToken(auth);
            response.setHeader("mytoken",token);
        }

        filterChain.doFilter(request,response);

    }

}
