package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.User;

@Repository("user_Repository")
public interface User_Repository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
	 List<User> findByfirstnameLike(String firstname); 
}
