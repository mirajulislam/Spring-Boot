package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Country;

@Repository("countryRepository")
public interface CountryRepository extends CrudRepository<Country, Integer> {

}