package com.zapadlinski.taskmanagementv2.taskUnits.module;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class ModuleServiceImpl implements ModuleService{
    private final ModuleRepository repository;

    @Autowired
    public ModuleServiceImpl(ModuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Module save(Module module) {
        repository.save(module);
        log.info("Saving module.");
        return module;
    }

    @Override
    public Module get(Long id) {
        Optional<Module> optionalModule = repository.findById(id);
        if (optionalModule.isEmpty())
            throw new IllegalStateException("There's no module with given id.");
        Module queriedModule = optionalModule.get();
        log.info("Getting module by id.");
        return queriedModule;
    }

    @Override
    public Collection<Module> listAll() {
        log.info("Getting collection of all modules.");
        return repository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        log.info("Deleting module by id.");
        return Boolean.TRUE;
    }
}
