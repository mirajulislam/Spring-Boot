package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, String> {
    User findByEmailIdIgnoreCase(String emailId);

}