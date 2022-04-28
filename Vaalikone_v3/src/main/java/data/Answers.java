package data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "answers.findAll", query = "SELECT a from answers a")
public class Answers implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candId;
	private int questId;
	private int answer;
	
	// bi-directional many-to-one association to candidates
	@ManyToOne
	private Candidates candidates;

	// bi-directional many-to-one association to question1
	@ManyToOne
	private Question question;

	public Answers(int candId, int questId, int answer) {
		this.candId = candId;
		this.questId = questId;
		this.answer = answer;
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public int getQuestId() {
		return questId;
	}

	public void setQuestId(int questId) {
		this.questId = questId;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String toString() {
		return questId + ": " + candId + " " + answer;
	}

	public Candidates getCandidate() {
		return this.candidates;
	}

	public void setCandidate(Candidates candidate) {
		this.candidates = candidate;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
	
	
}
