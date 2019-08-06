package SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBoot.entites.User;
@Repository
public interface User_Repository extends JpaRepository<User, Integer> {
	 User findByEmailIgnoreCase(String email);
}
