package com.example.community1.config;

import com.example.community1.authentication.JwtAuthenticationFilter;
import com.example.community1.authentication.LoginAuthenticationFilter;
import com.example.community1.authentication.UsernamePasswordAuthenticationProvider;
import com.example.community1.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;
    JwtUtil jwtUtil;

    public SecurityConfig(UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider, JwtUtil jwtUtil) {
        this.usernamePasswordAuthenticationProvider = usernamePasswordAuthenticationProvider;
        this.jwtUtil = jwtUtil;
    }

    @Autowired
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(new AuthenticationProvider[]{this.usernamePasswordAuthenticationProvider});
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http)throws Exception{
        http.formLogin((formLogin) -> formLogin.disable());
        http.httpBasic((httpBasic) -> httpBasic.disable());
        http.csrf((csrf) -> csrf.disable());
        http.addFilterAt(new LoginAuthenticationFilter(jwtUtil, authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(jwtUtil), LoginAuthenticationFilter.class);

        http.authorizeHttpRequests(authz -> authz
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/signup").permitAll()
                    .requestMatchers("/hello").permitAll()
                    .requestMatchers("/community").permitAll()
                    .requestMatchers("/funcommunity").permitAll()
                    .requestMatchers("/ootd").permitAll()
                    .requestMatchers("/usedsales").permitAll()
                    .requestMatchers("/usedpurchase").permitAll()
                    .requestMatchers("/detailmypost").permitAll()
                    .requestMatchers("/detailpost").permitAll()
                    .requestMatchers("/detailpost/comments").permitAll()
                    .anyRequest().authenticated());

        return http.build();
    }
}

