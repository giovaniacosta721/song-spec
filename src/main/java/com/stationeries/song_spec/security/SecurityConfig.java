package com.stationeries.song_spec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity during development
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/songs/**").permitAll() // Allow access to all for /songs
                        .requestMatchers("/songs/**").hasRole("USER") // Require ROLE_USER for /songs POST
                        .anyRequest().authenticated() // Authenticate all other endpoints
                )
                .httpBasic(Customizer.withDefaults()); // Enable basic authentication for testing
        return http.build();
    }

}