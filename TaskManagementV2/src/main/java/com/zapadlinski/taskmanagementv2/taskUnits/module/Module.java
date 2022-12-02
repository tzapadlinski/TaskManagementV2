package com.zapadlinski.taskmanagementv2.taskUnits.module;

import com.zapadlinski.taskmanagementv2.taskUnits.TaskUnit;
import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import com.zapadlinski.taskmanagementv2.taskUnits.project.Project;
import com.zapadlinski.taskmanagementv2.taskUnits.task.Task;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "modules")
@Data
@NoArgsConstructor
public class Module extends TaskUnit {

   /* @OneToMany(targetEntity = Task.class)
    private List tasks;

    public Module(Long id, String name, UnitStatus status, LocalDate deadline, List tasks) {
        super(id, name, status, deadline);
        this.tasks = tasks;
    } */

    public Module(String name, UnitStatus status, LocalDate deadline) {
        super(name, status, deadline);
    }
}
