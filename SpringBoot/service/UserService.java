package SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBoot.entites.User;
import SpringBoot.entites.UserQuestion;
import SpringBoot.repository.Question_Repository;
import SpringBoot.repository.UserQuestion_Repo;
import SpringBoot.repository.User_Repository;

@Service
public class UserService {
	
	@Autowired
	private UserQuestion_Repo userQuestion_Repo;
	
//	@Autowired
//	private Question_Repository question_Repository;
//	
	@Autowired
	private  User_Repository user_Repository;
	
	public List<User> getAllData(){
		return user_Repository.findAll();
		
	}

}
