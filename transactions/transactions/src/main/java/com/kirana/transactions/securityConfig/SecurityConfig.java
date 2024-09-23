package com.kirana.transactions.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
 

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for simplicity (not recommended for production)
            .authorizeHttpRequests()
            .requestMatchers("/api/transactions/**").permitAll() // Allow access to all transaction API endpoints
            .anyRequest().authenticated() // Require authentication for other endpoints
            .and()
            .formLogin().disable(); // Disable the login form for APIs

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() throws Exception {
        UserDetails readWriteUser = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("READ_WRITE")
                .build();
        UserDetails readOnlyUser = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("READ_ONLY")
                .build();
        return new InMemoryUserDetailsManager(readWriteUser, readOnlyUser);
    }
}
