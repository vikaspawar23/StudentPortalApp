package com.sps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sps.modal.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
