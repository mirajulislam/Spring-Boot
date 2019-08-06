package SpringBoot.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_data")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int u_id;
	private String name;
	private String email;	
	private String password;
	private String gender;
	 private boolean isEnabled;
	
	
	@JsonBackReference
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<UserQuestion> userQuestion;

	public User() {
		
	}
	
   public User(int u_id) {
		this.u_id=u_id;
	}

    public User(String name, String email, String password, String gender, boolean isEnabled
			) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.isEnabled = isEnabled;
	}


	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	public List<UserQuestion> getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(List<UserQuestion> userQuestion) {
		this.userQuestion = userQuestion;
	}

}
