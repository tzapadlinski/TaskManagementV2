package com.zapadlinski.taskmanagementv2.taskUnits.module;

import com.zapadlinski.taskmanagementv2.taskUnits.TaskUnit;
import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import com.zapadlinski.taskmanagementv2.taskUnits.project.Project;
import com.zapadlinski.taskmanagementv2.taskUnits.task.Task;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@Entity
@Table(name = "modules")
@Getter
@Setter
@NoArgsConstructor
public class Module extends TaskUnit {


    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "module", cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Module(Long id, String name, UnitStatus status,
                  LocalDate startDate, LocalDate deadline, List<Task> tasks) {
        super(id, name, status, startDate, deadline);
        this.tasks = tasks;
    }
}
