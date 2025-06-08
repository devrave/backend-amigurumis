package com.amigurumis_atelier.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/auth/login",
                    "/api/auth/register",
                    "/api/ping",
                    "/api/productos/**",
                    "/api/carritos/**",
                    "/api/pedidos/**",
                    "/api/roles/**",
                    "/api/metodospago/**",
                    "/api/detallecarrito/**",
                    "/api/detallepedido/**"
                ).permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
