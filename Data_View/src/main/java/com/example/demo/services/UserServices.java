package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;



@Service
@Transactional
public class UserServices {
	 @Autowired
	    private UserRepository repo;
	 
	   public List<User> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(User product) {
	        repo.save(product);
	    }
	     
	    public Optional<User> get(Integer id) {
	        return repo.findById(id);
	    }
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }
	    
	    

}
