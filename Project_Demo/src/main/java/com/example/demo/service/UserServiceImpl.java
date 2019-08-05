package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.RoleRespository;
import com.example.demo.repository.User_Repository;
@Service("userService")
public class UserServiceImpl implements UserService{
	 @Autowired
	 private User_Repository user_Repository;
	 
//	 @Autowired
//	 private UserRepository userRepository;
	 
	 @Autowired RoleRespository roleRespository; 
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		  return user_Repository.findByEmail(email);
	}


	



	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return user_Repository.findAll();
	}


	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return user_Repository.getOne(id);
	}
	
    
	    public void delete(Long id) {
	    	
	    	user_Repository.deleteById(id);
	    }



		@Override
		public void saveUser(User user) {
			
			
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			
			user_Repository.save(user);
			
		}


		public List<User> findByName(String firstname) {
			// TODO Auto-generated method stub
			return  user_Repository.findByfirstnameLike("%"+firstname+"%");
		}


}
