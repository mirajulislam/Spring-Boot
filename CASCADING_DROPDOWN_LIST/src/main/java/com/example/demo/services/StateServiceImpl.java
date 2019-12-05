package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.StateEntity;
import com.example.demo.repositories.StateRepository;

@Service("stateService")
public class StateServiceImpl implements StateService {


	@Autowired
	private StateRepository stateRepository;
	
	public List<StateEntity> findByCountry(int id) {
		return stateRepository.findByCountry(id);
	}
}
