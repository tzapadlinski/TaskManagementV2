package com.zapadlinski.taskmanagementv2.user;

import com.zapadlinski.taskmanagementv2.user.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Programmer")
@Data
@NoArgsConstructor
public class Programmer extends Employee {

    public Programmer(Long id, String username, String password, String firstName, String lastName) {
        super(id, username, password, firstName, lastName);
    }
}
