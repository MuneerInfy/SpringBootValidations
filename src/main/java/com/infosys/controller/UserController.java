package com.infosys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.model.User;
import com.infosys.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> add(@Valid @RequestBody User user){
		
	User userAdded=	service.addUser(user);
		return new  ResponseEntity<User>(userAdded, HttpStatus.CREATED);
		
	}
}
