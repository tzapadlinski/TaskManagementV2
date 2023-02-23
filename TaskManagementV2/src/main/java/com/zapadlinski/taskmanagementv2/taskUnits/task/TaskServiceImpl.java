package com.zapadlinski.taskmanagementv2.taskUnits.task;

import com.zapadlinski.taskmanagementv2.taskUnits.status.StatusValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;
    private final StatusValidator statusValidator;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, StatusValidator statusValidator) {
        this.taskRepository = taskRepository;
        this.statusValidator = statusValidator;
    }

    @Override
    public Task save(Task task) {
        Task savedTask = taskRepository.save(task);
        log.info("Saving task.");
        return savedTask;
    }

    @Override
    public Task get(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty())
            throw new IllegalStateException("There's no task with given id.");
        Task queriedTask = optionalTask.get();
        log.info("Getting task by id.");
        return queriedTask;
    }


    @Override
    public Collection<Task> listAll() {
        log.info("Getting collection of all tasks.");
        return taskRepository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        taskRepository.deleteById(id);
        log.info("Deleting task by id.");
        return Boolean.TRUE;
    }
}
