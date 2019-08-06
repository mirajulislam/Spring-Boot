package SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import SpringBoot.entites.Question;
import SpringBoot.entites.User;
import SpringBoot.entites.UserQuestion;
import SpringBoot.repository.Question_Repository;
import SpringBoot.repository.UserQuestion_Repo;
import SpringBoot.repository.User_Repository;
//  implements CommandLineRunner
@SpringBootApplication
public class BookPublicherApplication  {
	@Autowired
	private UserQuestion_Repo userQuestion_Repo;
	
	@Autowired
	private Question_Repository question_Repository;
	
	@Autowired
	private  User_Repository user_Repository;

	public static void main(String[] args) {
		SpringApplication.run(BookPublicherApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		User user=new User("raj","mirajulislam@gmail.com","123456","male",false);
//		Question question=new Question("What is Your name");		
//		UserQuestion userQuestion=new UserQuestion("Miraj","Raj");
//		userQuestion.setQuestion(question);
//		userQuestion.setUser(user);
//		user_Repository.save(user);
//		question_Repository.save(question);		
//		userQuestion_Repo.save(userQuestion);
//		
//	}

}
