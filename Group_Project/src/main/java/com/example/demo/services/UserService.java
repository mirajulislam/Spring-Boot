package com.example.demo.services;

import com.example.demo.entites.User;

public interface UserService {
	
	public User findUserByEmail(String email);	 
	 public void saveUser(User user);
	 public void saveAdmin(User user);

}
