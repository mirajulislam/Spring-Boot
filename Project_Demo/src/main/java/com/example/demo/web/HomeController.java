package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Message;
import com.example.demo.entities.User;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

@Controller
public class HomeController
{
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("msgs", messageRepository.findAll());		
		return "userhome";
	}
	
	@PostMapping("/messages")
	public String saveMessage(Message message)
	{
		messageRepository.save(message);
		return "redirect:/home";
	}
	
	 @RequestMapping(value= {"/admin/addUser"}, method=RequestMethod.GET)
	 public ModelAndView signup() {
	  ModelAndView model = new ModelAndView();
	  User user = new User();
	  model.addObject("user", user);
	  model.setViewName("/add_Admin_User");
	  
	  return model;
	 }
	
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	 public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {

	  ModelAndView model = new ModelAndView();
	  User userExists = userService.findUserByEmail(user.getEmail());
	  
	  if(userExists != null) {
	   bindingResult.rejectValue("email", "error.user", "This email already exists!");
	  }
	  if(bindingResult.hasErrors()) {
	   model.setViewName("/add_Admin_User");
	  } else {
		  
		  userService.saveUser(user);
	   model.addObject("msg", "User has been registered successfully!");
	   model.addObject("user", new User());
	   model.setViewName("/add_Admin_User");
	  }
	  
	  return model;
	 }
	 
//		@RequestMapping(value="/admin/Data", method=RequestMethod.GET)
//		public String goHome(Model model){
//			List<User> userShow=userService.getAllUsers();
//			model.addAttribute("userTable",userShow);
//			
//	         return "/displayData";
//		}
		
		@RequestMapping(value="/admin/Data", method=RequestMethod.GET)
		 public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
	        model.addAttribute("userTable", userRepository.findAll(new PageRequest(page, 4)));
	        model.addAttribute("buatPage", page);
	     
	        return "/displayData";
	    }
		
		
	    @GetMapping("/admin/delete")
	    public String deleteCountry(Integer id){
	    	userRepository.deleteById(id);
	        return "redirect:/";
	    }
	    
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView model = new ModelAndView("Data_Update");
	    Optional<User> user=userRepository.findById(id);
	    model.addObject("user", user);
	    return model;	    	
	    }
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveProduct(@ModelAttribute("user") User user) {
			userRepository.save(user);
			return "redirect:/";
		}

		@RequestMapping("/userSearch")
		public String listUsers(Model model, @RequestParam(defaultValue="")  String firstname) {
			model.addAttribute("usersearch", userServiceImpl.findByName(firstname));
			return "/SearchData";
		}
		
}
