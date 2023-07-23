package com.mykola.pagesmanager.configurations;

import com.mykola.pagesmanager.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security Java configuration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests((authz) -> authz
                        // Only registered users can save images
                        .requestMatchers("/images/add").authenticated()
                        .anyRequest().permitAll()
                )
                .userDetailsService(jpaUserDetailsService)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}

