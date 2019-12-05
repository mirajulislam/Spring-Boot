package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.State;
import com.example.demo.entities.StateEntity;

@Repository("stateRepository")
public interface StateRepository extends CrudRepository<State, Integer> {

	@Query("select new com.example.demo.entities.StateEntity(id, name) from State where country.id = :id")
	public List<StateEntity> findByCountry(@Param("id") int id);

}
