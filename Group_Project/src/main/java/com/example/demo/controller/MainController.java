package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entites.ConfirmationToken;
import com.example.demo.entites.Question;
import com.example.demo.entites.User;
import com.example.demo.entites.UserQuestion;
import com.example.demo.repository.ConfirmationTokenRepository;
import com.example.demo.repository.UserQuestion_Repository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.EmailSenderService;
import com.example.demo.services.QuestionService;
import com.example.demo.services.UserService;
//import com.example.demo.services.UserServiceImple;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionService questionService;

//	@Autowired
//	private UserServiceImple userServiceImple;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserQuestion_Repository userQuestion_Repository;
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	private EmailSenderService emailSenderService;

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("user/Registration");

		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public ModelAndView createUser(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult) {

		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exists!");
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("user/Registration");
		}

		else {

			userService.saveUser(user);

			ConfirmationToken confirmationToken = new ConfirmationToken(user);

			confirmationTokenRepository.save(confirmationToken);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject("Complete Registration!");
			mailMessage.setFrom("mirajulislam5746@gmail.com");
			mailMessage.setText("To confirm your account, please click here : "
					+ "http://localhost:8082/confirm-account?token=" + confirmationToken.getConfirmationToken());

			emailSenderService.sendEmail(mailMessage);
			modelAndView.addObject("email", user.getEmail());
//			            modelAndView.setViewName("successfulRegisteration");
			modelAndView.setViewName("user/SecondStep");

		}

		return modelAndView;

	}

	@RequestMapping(value = { "/Data" }, method = RequestMethod.GET)
	public ModelAndView secondStep() {
		 ModelAndView model = new ModelAndView();
//		 List<Question>question=questionService.GetAllQues();
//		 mod.addAttribute("quesname",question);
////		 
		 model.setViewName("user/SecondStep");
		return model;
	}
	
	@RequestMapping(value = { "/getData" }, method = RequestMethod.GET)
	public ModelAndView questionpage(Model mod) {
		 ModelAndView model = new ModelAndView();
		 List<Question>question=questionService.GetAllQues();
		 mod.addAttribute("quesname",question);
//		 
		 model.setViewName("user/questionpage");
		return model;
	}

	@RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			User user = userRepository.findByEmail(token.getUser().getEmail());
			user.setEnabled(true);
			userRepository.save(user);
			modelAndView.setViewName("accountVerified");
		} else {
			modelAndView.addObject("message", "The link is invalid or broken!");
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}
	
	@RequestMapping(value = { "/questionAns" }, method = RequestMethod.POST)
	public void saveAnswer(@RequestBody UserQuestion userQuestion) {
		userQuestion_Repository.save(userQuestion);
		System.out.println("Successfully insert");
		
	}
	

//		 public static void sendUserMail(String email) {
//		 User user;
//		 
//		 ConfirmationToken confirmationToken = new ConfirmationToken(user);
//
//        confirmationTokenRepository.save(confirmationToken);
//
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(user.getEmailId());
//        mailMessage.setSubject("Complete Registration!");
//        mailMessage.setFrom("mirajulislam5746@gmail.com");
//        mailMessage.setText("To confirm your account, please click here : "
//        +"http://localhost:8082/confirm-account?token="+confirmationToken.getConfirmationToken());
//
//        emailSenderService.sendEmail(mailMessage);
//
//        modelAndView.addObject("emailId", user.getEmailId());
//
//        modelAndView.setViewName("successfulRegisteration");
//	 }

}
