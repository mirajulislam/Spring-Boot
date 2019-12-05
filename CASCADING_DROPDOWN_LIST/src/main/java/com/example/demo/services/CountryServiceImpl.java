package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;

@Service("countryService")
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;

	
	@Override
	public Iterable<Country> findAll() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public Country find(int id) {
		// TODO Auto-generated method stub
		return countryRepository.findById(id).get();
	}

}
