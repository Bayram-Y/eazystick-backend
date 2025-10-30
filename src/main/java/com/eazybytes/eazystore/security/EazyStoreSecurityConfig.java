package com.eazybytes.eazystore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class EazyStoreSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return   http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/api/v1/products/**").permitAll()
                        .requestMatchers("api/v1/dummy/**").authenticated()
                        .anyRequest().authenticated()).formLogin(withDefaults())
                .formLogin(withDefaults())
                .httpBasic(withDefaults()).build();
    }
}
