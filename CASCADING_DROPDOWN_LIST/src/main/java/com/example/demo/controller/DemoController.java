package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.services.CityService;
import com.example.demo.services.CountryService;
import com.example.demo.services.StateService;
import com.google.gson.Gson;
@Controller
@RequestMapping(value = { "", "demo" })
public class DemoController {
	

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;

//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView country() {
////		modelMap.put("countries", countryService.findAll());
////		return "demo/index";
//		ModelAndView model = new ModelAndView();
//		model.setViewName("demo/index");
//		return model;
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("countries", countryService.findAll());
		return "demo/index";
	}

	@ResponseBody
	@RequestMapping(value = "loadStatesByCountry/{id}", method = RequestMethod.GET)
	public String loadStatesByCountry(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson(stateService.findByCountry(id));
	}

	@ResponseBody
	@RequestMapping(value = "loadCitiesByState/{id}", method = RequestMethod.GET)
	public String loadCitiesByState(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson(cityService.findByState(id));
	}

}
