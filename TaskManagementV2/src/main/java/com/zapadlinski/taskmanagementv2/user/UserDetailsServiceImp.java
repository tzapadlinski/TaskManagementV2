package com.zapadlinski.taskmanagementv2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {      //TODO logi?
    private final EmployeeRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> retrievedEmployee = repository.findEmployeeByUsername(username);
        if (retrievedEmployee.isEmpty()) {
            throw new BadCredentialsException("Invalid login details");
        }
        Employee employee = retrievedEmployee.get();
        return new EmployeeDetails(employee);
    }
}
