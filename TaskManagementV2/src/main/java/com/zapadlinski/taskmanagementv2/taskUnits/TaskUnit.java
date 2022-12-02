package com.zapadlinski.taskmanagementv2.taskUnits;

import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.*;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Data
@NoArgsConstructor
public abstract class TaskUnit {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private UnitStatus status;
    private LocalDate deadline;

    public TaskUnit(String name, UnitStatus status, LocalDate deadline) {
        this.name = name;
        this.status = status;
        this.deadline = deadline;
    }
}
