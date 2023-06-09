package com.focus.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurations {
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/swagger-ui.html**",
            "/webjars/**",
            // -- login
            "/api/session/**"
    };

    // @Bean
    // AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    //     return configuration.getAuthenticationManager();
    // }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic();

        //  Permit Cross Origins
        http.csrf().disable();
        http.cors();

        http.authorizeHttpRequests((auth) -> auth
            .requestMatchers(AUTH_WHITELIST).permitAll()
            .anyRequest().authenticated()
        );

        // Permit all authentication requests
        // http.authorizeHttpRequests().requestMatchers(request -> request.getServletPath().startsWith("/swagger-ui/**")).permitAll();
        // http.authorizeHttpRequests().requestMatchers(AUTH_WHITELIST).permitAll();
        // http.authorizeHttpRequests().anyRequest().authenticated();


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
