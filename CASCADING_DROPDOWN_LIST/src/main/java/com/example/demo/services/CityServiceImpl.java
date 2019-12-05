package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CityEntity;
import com.example.demo.repositories.CityRepository;

@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<CityEntity> findByState(int id) {
		return cityRepository.findByState(id);
	}
}
