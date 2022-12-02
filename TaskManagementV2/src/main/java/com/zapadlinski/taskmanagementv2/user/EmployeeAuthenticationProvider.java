package com.zapadlinski.taskmanagementv2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EmployeeAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailsServiceImp userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String givenUsername = authentication.getName();
        String givenPassword = authentication.getCredentials().toString();
        EmployeeDetails employeeDetails = (EmployeeDetails) userDetailsService.loadUserByUsername(givenUsername);
        String username = employeeDetails.getUsername();
        String password = employeeDetails.getPassword();
        if (givenPassword.equals(password)){
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(username, password, employeeDetails.getAuthorities());
            token.setDetails(employeeDetails.getEmployee());
            return token;
        }
        else {
            return null;
            //throw new BadCredentialsException("Invalid login details");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}