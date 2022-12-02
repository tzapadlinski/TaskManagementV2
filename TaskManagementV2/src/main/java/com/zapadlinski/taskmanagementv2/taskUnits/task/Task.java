package com.zapadlinski.taskmanagementv2.taskUnits.task;

import com.zapadlinski.taskmanagementv2.taskUnits.TaskUnit;
import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import com.zapadlinski.taskmanagementv2.taskUnits.module.Module;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name= "tasks")
@Data
@NoArgsConstructor
public class Task extends TaskUnit {
    /*@ManyToOne(targetEntity = Module.class, cascade = CascadeType.DETACH)
    private Module parent;

    public Task(Long id, String name, UnitStatus status, LocalDate deadline, Module parent) {
        super(id, name, status, deadline);
        this.parent = parent;
    } */

    public Task(String name, UnitStatus status, LocalDate deadline) {
        super(name, status, deadline);
    }
}
