package SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBoot.entites.UserQuestion;

@Repository
public interface UserQuestion_Repo extends JpaRepository<UserQuestion, Integer>{

}
