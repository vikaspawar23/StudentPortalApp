package com.sps.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.sps.modal.Student;

@Service
public interface StudentService {

	public void upsert(Student student);

	public List<Student> getAllStudents();
	

}
