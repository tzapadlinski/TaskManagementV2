package com.zapadlinski.taskmanagementv2.taskUnits;

import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;

import java.time.LocalDate;
import java.util.Collection;

public interface TaskUnitService<T extends TaskUnit> {

    public T save(T taskUnit);
    public T get(Long id);
    public Collection<T> list();
    public T changeStatus(Long id, UnitStatus status);
    public T changeDeadline(Long id, LocalDate deadline);
    public Boolean delete(Long id);
}
