/*
package com.zapadlinski.taskmanagementv2.taskUnits.task;

import com.zapadlinski.taskmanagementv2.taskUnits.status.UnitStatus;
import com.zapadlinski.taskmanagementv2.taskUnits.wrappers.IdDateWrapper;
import com.zapadlinski.taskmanagementv2.taskUnits.wrappers.IdStatusWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskServiceImplementation taskService;

    @GetMapping("/list")
    @ResponseBody
    public Collection<Task> showList() {
        return taskService.listAll();
    }

    @GetMapping
    public ResponseEntity<Task> showTask(@RequestParam(name = "id") Long id) {
        Task queriedTask = taskService.get(id);
        return ResponseEntity.of(Optional.of(queriedTask));
    }

    @PostMapping("/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task savedTask = taskService.save(task);
        return ResponseEntity.of(Optional.of(task));
    }

    @PutMapping("/update/deadline")
    public ResponseEntity<Task> changeTaskDeadline(@RequestBody IdDateWrapper wrapper) {
        Long id = wrapper.id();
        LocalDate date = wrapper.date();
        Task updatedTask = taskService.changeDeadline(id, date);
        return ResponseEntity.of(Optional.of(updatedTask));
    }

    @PutMapping("/update/status")
    public ResponseEntity<Task> changeTaskStatus(@RequestBody IdStatusWrapper wrapper) {
        Long id = wrapper.id();
        UnitStatus status = wrapper.status();
        Task updatedTask = taskService.changeStatus(id, status);
        return ResponseEntity.of(Optional.of(updatedTask));
    }

    @DeleteMapping(path = "/delete")
    @ResponseBody
    public Boolean delTask(@RequestParam(name = "id") Long id) {
       Boolean isDeleted = taskService.delete(id);
        return isDeleted;
    }
}
*/
