package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.CityEntity;

public interface CityService {
	public List<CityEntity> findByState(int id);
}
