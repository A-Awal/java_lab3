package com.example.java_lab5;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;

@Configuration
class SecurityConfig {

    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(request -> request
//                        .requestMatchers("/user").authenticated())
//
//                .httpBasic(Customizer.withDefaults())
//                .csrf(csrf -> csrf.disable());

//        http.authorizeHttpRequests(request -> request
//                        .requestMatchers("/admin")
//                        .hasRole("ADMIN"))
//                .httpBasic(Customizer.withDefaults())
//                .csrf(csrf -> csrf.disable());


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
