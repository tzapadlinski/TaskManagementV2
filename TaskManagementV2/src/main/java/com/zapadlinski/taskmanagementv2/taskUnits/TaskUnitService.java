package com.zapadlinski.taskmanagementv2.taskUnits;

import java.util.Collection;

public interface TaskUnitService<T extends TaskUnit> {

    public T save(T taskUnit);
    public T get(Long id);
    public Collection<T> listAll();
    public Boolean delete(Long id);
}
