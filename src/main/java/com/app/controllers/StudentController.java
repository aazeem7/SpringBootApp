package com.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Student;
import com.app.repository.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public String index() {
		return "Hello";
	}

	/* Find by Id */
	@GetMapping("/{id}")
	public Optional<Student> findById(@PathVariable("id") long id) {
		return studentRepository.findById(id);
	}
	/* Get all students */
	@GetMapping("/getAll")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	/* Save Single User */
	@PostMapping("/save")
	public ResponseEntity<Student> save(@RequestBody Student student) {
		return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
	}

	/* For Bulk save */
	@PostMapping("/saveAll")
	public ResponseEntity<List<Student>> saveAll(@RequestBody List<Student> students) {
		return new ResponseEntity<>(studentRepository.saveAll(students), HttpStatus.CREATED);
	}
	
	/* For updating a single resource */
	@PutMapping("/update/{id}")
	public void updateStudent(@RequestBody Student studentParam, @PathVariable("id") long id) {
		var student = studentRepository.getReferenceById(id);
		if (student != null) {
			student.setFirstname(studentParam.getFirstname());
			student.setLastname(studentParam.getLastname());
			student.setAge(studentParam.getAge());
			student.setProject(studentParam.getProject());
			student.setSubjects(studentParam.getSubjects());
			student.setAddress(studentParam.getAddress());
			studentRepository.save(student);
		}
	}
	
	/* For deleting */
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable("userId") long userId) {
		studentRepository.deleteById(userId);
	}	
	
	
}
