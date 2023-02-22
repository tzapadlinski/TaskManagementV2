package com.zapadlinski.taskmanagementv2.taskUnits.task;

import com.zapadlinski.taskmanagementv2.taskUnits.status.StatusValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImplementation implements TaskService{
    private final TaskRepository repository;
    private final StatusValidator statusValidator;

    @Override
    public Task save(Task task) {
        repository.save(task);
        log.info("Saving task.");
        return task;
    }

    @Override
    public Task get(Long id) {
        Task queriedTask = repository.findById(id).get();
        log.info("Getting task by id.");
        return queriedTask;
    }


    @Override
    public Collection<Task> listAll() {
        log.info("Getting collection of all tasks");
        return repository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        log.info("Deleting task by id");
        return Boolean.TRUE;
    }
}
