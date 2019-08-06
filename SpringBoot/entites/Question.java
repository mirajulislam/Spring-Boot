package SpringBoot.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user_question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int q_id;
	private String question_name;
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL,mappedBy="question")
	private List<UserQuestion> userQuestion;

	
	public Question(String question_name) {
		this.question_name = question_name;
	}

	public Question() {
		
	}
	
public Question(int q_id) {
		this.q_id=q_id;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getQuestion_name() {
		return question_name;
	}

	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}

	public List<UserQuestion> getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(List<UserQuestion> userQuestion) {
		this.userQuestion = userQuestion;
	}
	
	

}
