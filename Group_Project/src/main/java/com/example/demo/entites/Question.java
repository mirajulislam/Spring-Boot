package com.example.demo.entites;

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
@Table(name = "userquestion")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int quesId;
	private String quesName;
	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL,mappedBy="question")
	private List<UserQuestion> userQuestion;
	
	public Question() {
		
	}

	public Question(int quesId) {
	
		this.quesId = quesId;
	}

	public Question(String quesName) {
		this.quesName = quesName;
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getQuesName() {
		return quesName;
	}

	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}

	public List<UserQuestion> getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(List<UserQuestion> userQuestion) {
		this.userQuestion = userQuestion;
	}
	
	
	
	

}
