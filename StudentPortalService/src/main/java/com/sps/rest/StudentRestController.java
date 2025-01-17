package com.sps.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.modal.Student;

import com.sps.service.AddService;
import com.sps.service.StudentServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentRestController {

	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private AddService addService;

	@PostMapping
	public ResponseEntity<Void> addStudent(@RequestBody Student student) {
		studentService.upsert(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getstates")
	public List<String> getAllStates() {
		return addService.getAllStates();
	}

	@GetMapping("/getcities/{state}")
	public Optional<List<String>> getMethodName(@PathVariable String state) {
		return addService.getCitiesByState(state);
	}
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@DeleteMapping("/{email}")
	public void deleteById(@PathVariable String email) {
		 studentService.deleteById(email);
	}
	

}
