package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question>GetAllQues(){
		return questionRepository.findAll();
		
	}
	

}
