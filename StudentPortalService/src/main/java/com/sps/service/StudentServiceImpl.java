package com.sps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.modal.Student;
import com.sps.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepository studentRepository;

    @Override
    public void upsert(Student student) {
        studentRepository.save(student);
    }

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void deleteById(String email) {
		studentRepository.deleteById(email);
	}
    
    

  }
