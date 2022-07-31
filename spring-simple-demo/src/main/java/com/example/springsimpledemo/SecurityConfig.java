package com.example.springsimpledemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .authorizeHttpRequests((authz) -> authz
//                        .antMatchers("/", "/js/*", "/css/*", "index")
//                        .permitAll()
//                        .antMatchers("/api/**").hasRole(STUDENT.name())
//                        .anyRequest()
//                        .authenticated()
//                )
        .httpBasic(withDefaults());
        return http.build();
    }

}
