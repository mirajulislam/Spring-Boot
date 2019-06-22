package com.example.demo;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Controller
public class Dispaly_Data {
//	
	 @Autowired
	 private UserRepository userRepository;
	 @Autowired
	 private UserService userService;
	 @RequestMapping("/")
	 public String showPage(Model model, @RequestParam(defaultValue = "0") int page){
		
		   model.addAttribute("data", userRepository.
				     findAll(new PageRequest(page, 6)));
				     model.addAttribute("currentPage", page);
				     return "index";
	 }
	 
//	 @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
//	 public String home(Model model1, @RequestParam(defaultValue = "0") int page) {
//		 
//	  ModelAndView model = new ModelAndView();
//	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	  User user = userService.findUserByEmail(auth.getName());
//	  model.addObject("userName", user.getFirstname() + " " + user.getLastname());
//	  
//	             model1.addAttribute("data", userRepository.
//			     findAll(new PageRequest(page, 6)));
//			     model1.addAttribute("currentPage", page);
//	             model.setViewName("home/home");
//	             return "home/home";
//
//	 }
	    
	    @GetMapping("/delete")
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

}
