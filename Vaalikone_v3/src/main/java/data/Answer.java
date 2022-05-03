package data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the answers database table.
 * 
 */
@Entity
@Table(name="answers")
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int answer;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="CAND_ID")
	private Candidate candidate;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="QUEST_ID")
	private Question question;

	
	public Answer() {
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnswer() {
		return this.answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public String toString() {
		return "Answer: "+this.id+"/"+this.answer;
	}

}