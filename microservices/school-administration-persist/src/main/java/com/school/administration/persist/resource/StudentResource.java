package com.school.administration.persist.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.administration.persist.domain.Student;
import com.school.administration.persist.repository.StudentRepository;

@RestController
public class StudentResource {

	@Autowired
	StudentRepository repository;

	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return repository.findAll();
	}

}
