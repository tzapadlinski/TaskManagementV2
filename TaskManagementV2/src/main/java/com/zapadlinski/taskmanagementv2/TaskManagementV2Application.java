package com.zapadlinski.taskmanagementv2;

import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import com.zapadlinski.taskmanagementv2.taskUnits.module.Module;
import com.zapadlinski.taskmanagementv2.taskUnits.module.ModuleRepository;
import com.zapadlinski.taskmanagementv2.taskUnits.task.Task;
import com.zapadlinski.taskmanagementv2.taskUnits.task.TaskRepository;
import com.zapadlinski.taskmanagementv2.user.Employee;
import com.zapadlinski.taskmanagementv2.user.EmployeeRepository;
import com.zapadlinski.taskmanagementv2.user.Programmer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class TaskManagementV2Application {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementV2Application.class, args);
	}

	@Bean
	CommandLineRunner run(TaskRepository repository, EmployeeRepository employeeRepository) {
		return args -> {
			Task t1 = repository.save(new Task(
					"testowy1",
					UnitStatus.NEW,
					LocalDate.now()
					));
			Task t2 = repository.save(new Task(
					"testowy2",
					UnitStatus.IN_PROGRESS,
					LocalDate.of(2000, Month.APRIL, 2)
			));
			employeeRepository.save(new Programmer(
					null,
					"p1",
					"p1",
					"Krzysztof",
					"Bosak"
			));
		};
	}
}
