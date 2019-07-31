package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	/*
	public User getUserById(int id) {
		User obj = userRepository.findById(id).get();
		return obj;
	}	
	*/

}
