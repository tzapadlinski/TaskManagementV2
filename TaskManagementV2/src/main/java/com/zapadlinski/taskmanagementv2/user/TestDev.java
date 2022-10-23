package com.zapadlinski.taskmanagementv2.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestDev extends Employee{
    private int taskQuantity;       //will be used for automatic task distribution

    public TestDev(Long id, String username, String password, String firstName, String lastName, int taskQuantity) {
        super(id, username, password, firstName, lastName);
        this.taskQuantity = taskQuantity;
    }
}
