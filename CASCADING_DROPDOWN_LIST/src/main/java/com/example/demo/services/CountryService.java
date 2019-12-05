package com.example.demo.services;

import com.example.demo.entities.Country;

public interface CountryService {

	public Iterable<Country> findAll();

	public Country find(int id);
}
