package com.zapadlinski.taskmanagementv2.taskUnits.project;

import com.zapadlinski.taskmanagementv2.taskUnits.TaskUnit;
import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import com.zapadlinski.taskmanagementv2.taskUnits.module.Module;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Project extends TaskUnit {

    @OneToMany(targetEntity = Module.class)
    private List modules;

    public Project(String name, UnitStatus status, LocalDate deadline, List modules) {
        super(name, status, deadline);
        this.modules = modules;
    }
}
