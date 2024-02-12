package com.example.jdbc.springBootJDBC;

import com.example.jdbc.springBootJDBC.model.Students;
import com.example.jdbc.springBootJDBC.repo.StudentsRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		Students s1 = context.getBean(Students.class);
		s1.setId(6);
		s1.setName("Deepika");

		StudentsRepo sr = context.getBean(StudentsRepo.class);
		sr.save(s1);
		System.out.println(sr.fetchStudents());
	}

}
