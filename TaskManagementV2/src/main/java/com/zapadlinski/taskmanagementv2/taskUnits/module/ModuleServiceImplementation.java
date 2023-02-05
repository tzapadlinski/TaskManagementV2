package com.zapadlinski.taskmanagementv2.taskUnits.module;

import com.zapadlinski.taskmanagementv2.taskUnits.TaskUnit;
import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import com.zapadlinski.taskmanagementv2.taskUnits.task.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class ModuleServiceImplementation implements ModuleService{
    private final ModuleRepository repository;

    @Override
    public Module save(Module module) {
        repository.save(module);
        return module;
    }

    @Override
    public Module get(Long id) {
        Module queriedModule = repository.findById(id).get();
        return queriedModule;
    }

    public Collection<Module> list() {
        return repository.findAll();
    }

    @Override
    public Module changeStatus(Long id, UnitStatus status) {
        Module moduleToUpdate = repository.findById(id).get();
        moduleToUpdate.setStatus(status);
        repository.save(moduleToUpdate);
        return moduleToUpdate;
    }

    @Override
    public Module changeDeadline(Long id, LocalDate deadline) {
        Module moduleToUpdate = repository.findById(id).get();
        moduleToUpdate.setDeadline(deadline);
        repository.save(moduleToUpdate);
        return moduleToUpdate;
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return Boolean.TRUE;
    }
}
