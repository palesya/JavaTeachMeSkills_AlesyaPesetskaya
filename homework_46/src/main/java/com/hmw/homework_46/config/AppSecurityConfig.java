package com.hmw.homework_46.config;

import com.hmw.homework_46.filter.TokenGenerationFilter;
import com.hmw.homework_46.filter.TokenValidationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        prePostEnabled = true
)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenGenerationFilter generatorFilter;
    private final TokenValidationFilter validationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .authorizeHttpRequests()
                .antMatchers("/home").authenticated()
                .antMatchers("/all").permitAll()
                .and()
                .addFilterBefore(validationFilter, LogoutFilter.class)
                .addFilterAfter(generatorFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
