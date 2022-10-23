package com.zapadlinski.taskmanagementv2.user;

import com.zapadlinski.taskmanagementv2.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Optional<Employee> findEmployeeByUsername(String Username);
}
