package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepo;

    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("data", countryRepo.
        findAll(new PageRequest(page, 7)));
        model.addAttribute("currentPage", page);
        return "index";
    }

    @PostMapping("/save")
    public String save(Country c){
        countryRepo.save(c);

        return "redirect:/";
    }
    @GetMapping("/delete")
    public String deleteCountry(Integer id){
        countryRepo.deleteById(id);

        return "redirect:/";
    }
//    
    @GetMapping("/findOne")
    @ResponseBody
    public Optional<Country> findOne(Integer id){
        return countryRepo.findById(id);
    }
	
}


