package com.example.java_lab5.extras;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
class SecurityConfig {
@Bean
SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> {
            request
                        .requestMatchers("/api/product/**").hasRole("ADMIN")
                        .requestMatchers("/api/purchases/**").hasRole("USER")
                        .requestMatchers("/api/customer/**").hasRole("USER")
                        .anyRequest().authenticated();

        });
        http.sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic(Customizer.withDefaults());
        http.csrf(c -> c.disable());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService testOnlyUsers(PasswordEncoder passwordEncoder) {
        User.UserBuilder users = User.builder();
        UserDetails awal = users
                .username("awal")
                .password(passwordEncoder.encode("awal"))
                .roles("ADMIN")
                .build();
        UserDetails aw = users
                .username("aw")
                .password(passwordEncoder.encode("aw"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(awal, aw);
    }
}
