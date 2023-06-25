package com.focus.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration {
    private static final String[] AUTH_WHITELIST = {
        // -- swagger ui
        "/swagger-ui/index.html",
        "/v2/api-docs/**",
        "/v1/api-docs/**",
        // -- login
        "/api/login",
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}