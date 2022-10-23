package com.zapadlinski.taskmanagementv2.user;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (!retrievedEmployee.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        Employee employee = retrievedEmployee.get();
        return new EmployeeDetails(employee);
    }
}
