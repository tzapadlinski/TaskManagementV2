package com.zapadlinski.taskmanagementv2.taskUnits.project;

import com.zapadlinski.taskmanagementv2.taskUnits.task.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Project save(Project taskUnit) {
        Project savedProject = projectRepository.save(taskUnit);
        log.info("Saving project.");
        return savedProject;
    }

    @Override
    public Project get(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isEmpty())
            throw new IllegalStateException("There's no project with given id");
        Project queriedProject = optionalProject.get();
        log.info("Getting task by id.");
        return queriedProject;
    }

    @Override
    public Collection<Project> listAll() {
        log.info("Getting collection of all projects.");
        return projectRepository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        log.info("Deleting project by id.");
        return Boolean.TRUE;
    }
}
