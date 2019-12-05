package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.StateEntity;

public interface StateService {
	public List<StateEntity> findByCountry(int id);
}
