package com.sps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.modal.User;
import com.sps.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserRestController {
	
	 @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody User user) {
	        userService.saveUser(user);
	        return ResponseEntity.ok("User registered successfully");
	    }

	    @PostMapping("/login")
	    public ResponseEntity<Boolean> login(@RequestBody User user) {
	        boolean isValid = userService.validate(user);
	        if (isValid) {
	            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	        } else {
	            return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
	        }
	    }

}
