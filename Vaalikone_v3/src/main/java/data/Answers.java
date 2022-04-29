//package data;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
//
//@Entity
//@NamedQuery(name = "answers.findAll", query = "SELECT a from Answers a")
//public class Answers implements Serializable {
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "cand_id")
//	private int candId;
//	@Column(name = "quest_id")
//	private int questId;
//	private int answer;
//	
//	// bi-directional many-to-one association to candidates
//	@ManyToOne
//	private Candidates candidates;
//
//	// bi-directional many-to-one association to question1
//	@ManyToOne
//	private Question questions;
//
//	public Answers(int candId, int questId, int answer) {
//		this.candId = candId;
//		this.questId = questId;
//		this.answer = answer;
//	}
//
//	public Answers() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public int getCandId() {
//		return candId;
//	}
//
//	public void setCandId(int candId) {
//		this.candId = candId;
//	}
//
//	public int getQuestId() {
//		return questId;
//	}
//
//	public void setQuestId(int questId) {
//		this.questId = questId;
//	}
//
//	public int getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(int answer) {
//		this.answer = answer;
//	}
//
//	public String toString() {
//		return questId + ": " + candId + " " + answer;
//	}
//
//	public Candidates getCandidate() {
//		return this.candidates;
//	}
//
//	public void setCandidate(Candidates candidate) {
//		this.candidates = candidate;
//	}
//
//	public Question getQuestion() {
//		return this.questions;
//	}
//
//	public void setQuestion(Question questions) {
//		this.questions = questions;
//	}
//
//	
//	
//	
//	
//}
