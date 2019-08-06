package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.UserQuestion;
@Repository
public interface UserQuestion_Repository extends JpaRepository<UserQuestion, Integer>{

}
