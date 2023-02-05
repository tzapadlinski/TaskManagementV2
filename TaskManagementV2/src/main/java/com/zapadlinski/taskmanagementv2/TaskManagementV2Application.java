package com.zapadlinski.taskmanagementv2;


import com.zapadlinski.taskmanagementv2.taskUnits.task.TaskRepository;
import com.zapadlinski.taskmanagementv2.user.EmployeeRepository;
import com.zapadlinski.taskmanagementv2.user.Programmer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskManagementV2Application {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementV2Application.class, args);
	}

	@Bean
	CommandLineRunner run(TaskRepository repository, EmployeeRepository employeeRepository) {
		return args -> {
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
