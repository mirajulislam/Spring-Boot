package SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import SpringBoot.entites.User;
import SpringBoot.repository.ConfirmationTokenRepository;
import SpringBoot.repository.User_Repository;
import SpringBoot.service.EmailSenderService;
import SpringBoot.service.UserService;

@RestController
public class Controller_Api {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private User_Repository user_Repository;
	
	 @Autowired
	 private ConfirmationTokenRepository confirmationTokenRepository;
	   
	 @Autowired
	 private EmailSenderService emailSenderService;
	
//	@GetMapping("/userAll")	
//	public List<User> getAllUser(){
//		return userService.getAllData();
//	}
	 
	  @RequestMapping(value="/register", method = RequestMethod.POST)
	  
	  public ModelAndView registerUser(ModelAndView modelAndView, User user) 
	  {
		  User existingUser=user_Repository.findByEmailIgnoreCase(user.getEmail());
		  if(existingUser !=null) {
//			   System.out.println("Email all Use");
			  modelAndView.addObject("message","This email already exists!");
	          modelAndView.setViewName("error");
		  }
		return modelAndView;
		  
		  
	  }

}
