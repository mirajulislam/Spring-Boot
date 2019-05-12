package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Country;
import java.io.Serializable;
public interface CountryRepository extends JpaRepository<Country, Integer> {


//
//	void delete(Integer id);
	
	

}
