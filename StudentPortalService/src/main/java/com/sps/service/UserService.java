package com.sps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.modal.User;
import com.sps.repositories.UserRepository;

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repository;
	
	public void saveUser(User user) {
		repository.save(user);
	}
	
	@SuppressWarnings("deprecation")
	public boolean validate(User user) {
		 User temp = repository.getById(user.getEmail());
		 if (temp.getPassword().equals(user.getPassword())) {
			return true;
		}
		 return false;
	}

}
