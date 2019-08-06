package com.example.demo.entites;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "userquestionanswer")
public class UserQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int useransId;	
	private String firstAnswer;
	private String secondAnswer;
	
	@JoinColumn(name="userId",referencedColumnName="userId")
	@ManyToOne(optional=false)
	private User user;
	@JsonManagedReference
	@JoinColumn(name="quesId",referencedColumnName="quesId")
	@ManyToOne(optional=false)
	private Question question;
	
	
	
	public UserQuestion() {
	
	}

	public UserQuestion(int useransId) {
		this.useransId = useransId;
	}

	public UserQuestion(String firstAnswer, String secondAnswer) {
		this.firstAnswer = firstAnswer;
		this.secondAnswer = secondAnswer;
	}

	public int getUseransId() {
		return useransId;
	}

	public void setUseransId(int useransId) {
		this.useransId = useransId;
	}

	public String getFirstAnswer() {
		return firstAnswer;
	}

	public void setFirstAnswer(String firstAnswer) {
		this.firstAnswer = firstAnswer;
	}

	public String getSecondAnswer() {
		return secondAnswer;
	}

	public void setSecondAnswer(String secondAnswer) {
		this.secondAnswer = secondAnswer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
	

}
