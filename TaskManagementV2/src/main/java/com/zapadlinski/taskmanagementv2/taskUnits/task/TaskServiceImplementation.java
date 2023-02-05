package com.zapadlinski.taskmanagementv2.taskUnits.task;

import com.zapadlinski.taskmanagementv2.taskUnits.StatusValidator;
import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import com.zapadlinski.taskmanagementv2.taskUnits.module.ModuleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        log.info("Creating new task");
        return task;
    }

    @Override
    public Task get(Long id) {
        Task queriedTask = repository.findById(id).get();
        log.info("Getting task by id");
        return queriedTask;
    }

    @Override
    public Collection<Task> list() {
        log.info("Getting collection of all tasks");
        return repository.findAll();
    }

    @Override
    public Task changeStatus(Long id, UnitStatus status) {
        Task taskToUpdate = get(id);
        log.info("Modifying task's status");
        if (statusValidator.validate(taskToUpdate, status, null)) {
            taskToUpdate.setStatus(status);
            repository.save(taskToUpdate);
            log.info("Task's status modification succeeded");
        }
        else {
            log.info("Task's status modification failed");
            //TODO throw exception
        }
        return taskToUpdate;
    }

    @Override
    public Task changeDeadline(Long id, LocalDate deadline) {
        Task taskToUpdate = get(id);
        taskToUpdate.setDeadline(deadline);
        repository.save(taskToUpdate);
        log.info("Modifying task's deadline");
        return taskToUpdate;
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        log.info("Deleting task by id");
        return Boolean.TRUE;
    }
}
