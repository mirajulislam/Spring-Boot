package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.ProductServic;

@Controller
@RequestMapping("")
public class IndexController {
	@Autowired
	private ProductServic productServic;
	
	@RequestMapping(value = { "/insertProduct" }, method = RequestMethod.GET)
	public ModelAndView insert() {
		return productServic.viewInsertProductPage();
	}

}
