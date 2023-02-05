package com.zapadlinski.taskmanagementv2.taskUnits.task;

import com.zapadlinski.taskmanagementv2.taskUnits.TaskUnit;
import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import com.zapadlinski.taskmanagementv2.taskUnits.module.Module;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name= "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task extends TaskUnit {

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    public Task(Long id, String name, UnitStatus status, LocalDate startDate, LocalDate deadline, Module module) {
        super(id, name, status, startDate, deadline);
        this.module = module;
    }
}
