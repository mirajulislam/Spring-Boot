package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	public List<User> getAllUsers();
	public User getUserById(Long id);
    public void saveUser(User user);
	


}
