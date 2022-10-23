package com.zapadlinski.taskmanagementv2.configs;

import com.zapadlinski.taskmanagementv2.user.EmployeeRepository;
import com.zapadlinski.taskmanagementv2.user.UserDetailsServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorization -> authorization
                        .anyRequest()
                        .permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .permitAll()
                )
                .csrf( csrf -> csrf.disable())
                .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(EmployeeRepository repository) {
        return new UserDetailsServiceImp(repository);
    }

}