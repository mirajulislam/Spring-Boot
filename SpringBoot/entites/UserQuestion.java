package SpringBoot.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "job_question")
public class UserQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int u_q_id;
	private String ans;
	private String ans2;
	
	
	@JoinColumn(name="u_id",referencedColumnName="u_id")
	@ManyToOne(optional=false)
	private User user;
	@JsonManagedReference
	@JoinColumn(name="q_id",referencedColumnName="q_id")
	@ManyToOne(optional=false)
	private Question question;
	
	
	public UserQuestion() {
		
	}

	public UserQuestion(int u_q_id) {
		this.u_q_id = u_q_id;
	}

	public UserQuestion(String ans, String ans2) {
		
		this.ans = ans;
		this.ans2 = ans2;
	}

	public String getAns2() {
		return ans2;
	}



	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}



	public int getU_q_id() {
		return u_q_id;
	}

	public void setU_q_id(int u_q_id) {
		this.u_q_id = u_q_id;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
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
