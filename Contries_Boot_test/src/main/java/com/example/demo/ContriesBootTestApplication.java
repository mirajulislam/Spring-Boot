package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;

@SpringBootApplication
public class ContriesBootTestApplication implements CommandLineRunner{
	
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContriesBootTestApplication.class, args);
	}
	

	public void run(String... strings) throws Exception {
		
		countryRepository.save(new Country("Earth", "World"));
		countryRepository.save(new Country("China", "Peking"));
		countryRepository.save(new Country("Germany", "Berlin"));
		countryRepository.save(new Country("USA", "Washington DC"));
		countryRepository.save(new Country("Russia", "Moscow"));
		countryRepository.save(new Country("Namibia", "Windhoek"));
		countryRepository.save(new Country("India", "New Delhi"));
		countryRepository.save(new Country("North Korea", "Pyongyang"));
		countryRepository.save(new Country("Kenya", "Nairobi"));
		countryRepository.save(new Country("Canada", "Ottawa"));
		countryRepository.save(new Country("Jamaica", "Kingston"));
		countryRepository.save(new Country("Brazil", "Brasilia"));
		countryRepository.save(new Country("Egypt", "Cairo"));
		countryRepository.save(new Country("Nigeria", "Abuja"));
		countryRepository.save(new Country("Jordan", "Amman"));
		countryRepository.save(new Country("Curacao", "Willemstad"));
		countryRepository.save(new Country("Sao Tome Principe", "Sao Tome"));
	}

}
