package SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.entites.Question;

public interface Question_Repository extends JpaRepository<Question, Integer>{

}
