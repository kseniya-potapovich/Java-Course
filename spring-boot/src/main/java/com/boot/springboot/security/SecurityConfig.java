package com.boot.springboot.security;

import com.boot.springboot.security.filter.JwtFilter;
import com.boot.springboot.security.service.CustomUserDetailService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SecurityScheme(name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer")
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    @Autowired
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**"))
                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**"))
        );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //для правильной обработки запроса
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(new AntPathRequestMatcher("/user", "GET")).hasRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/security/registration", "POST")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/security/token", "POST")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/admin", "POST")).hasRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/user/info", "GET")).hasAnyRole("USER", "ADMIN")
                                .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //кодировщик
        return new BCryptPasswordEncoder();
    }
}
