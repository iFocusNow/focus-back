package com.focus.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfigurations {
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            // -- login
            //"/api/login/**"
    };

    // @Bean
    // AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    //     return configuration.getAuthenticationManager();
    // }

    // @Bean
    // SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http.csrf().disable();
    //     http.cors(withDefaults());

    //     http.authorizeHttpRequests( (auth) ->auth
    //             .requestMatchers(AUTH_WHITELIST).permitAll()
    //             .anyRequest().authenticated()
    //             //.anyRequest().permitAll()

    //     );

    //     http.sessionManagement( (session)-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    //     return http.build();
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
