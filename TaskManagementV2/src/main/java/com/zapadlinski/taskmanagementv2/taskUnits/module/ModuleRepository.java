package com.zapadlinski.taskmanagementv2.taskUnits.module;

import com.zapadlinski.taskmanagementv2.taskUnits.TaskUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
