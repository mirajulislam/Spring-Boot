package com.example.demo.entites;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "userdata")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int userId;
	private String userName;
	private String email;
	private String password;
	private String gender;
	private String designation;
	private boolean isEnabled;
	
	@JsonBackReference
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<UserQuestion> userQuestion;
	
	 @ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="user_role", joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="roleId"))
	 private Set<Role> roles;
	
	public User() {
		
	}

	public User(int userId) {
		this.userId = userId;
	}

	public User(String userName, String email, String password, String gender, String designation, boolean isEnabled) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.designation = designation;
		this.isEnabled = isEnabled;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<UserQuestion> getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(List<UserQuestion> userQuestion) {
		this.userQuestion = userQuestion;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	

}
