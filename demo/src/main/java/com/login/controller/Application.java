package com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class Application {
	@ResponseBody
	
@RequestMapping("/home")
	public String Hello() {
		
	return "hi";
	}
	
	@RequestMapping("/welcome")
	public String Welcome() {
		return "welcomepage";
	}
}
