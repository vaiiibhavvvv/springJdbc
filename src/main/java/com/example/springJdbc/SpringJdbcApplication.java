package com.example.springJdbc;

import com.example.springJdbc.model.Student;
import com.example.springJdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

	Student student = context.getBean(Student.class);
	student.setRollNo(21);
	student.setName();
	student.setMarks(10);

		StudentService service = context.getBean(StudentService.class);


	service.addStudent(student);

		List<Student> students = service.getStudents();

	}
}
