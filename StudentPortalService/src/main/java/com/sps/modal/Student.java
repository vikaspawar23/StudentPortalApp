package com.sps.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

	private String name;

	@Id
	private String email;

	private String education;
	private String state;
	private String city;
	private String password;
	private String gender;
	private String subjects;

}
