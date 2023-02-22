package com.zapadlinski.taskmanagementv2.taskUnits.module;

import com.zapadlinski.taskmanagementv2.taskUnits.status.UnitStatus;
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

    @Override
    public Collection<Module> listAll() {
        return repository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return Boolean.TRUE;
    }
}
