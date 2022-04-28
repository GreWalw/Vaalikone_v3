package data;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
@NamedQuery(name = "questions.findAll", query = "SELECT q from questions q")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int qnumber;
	private String question;

	
	@OneToMany(mappedBy="question")
//	@JoinTable(name = "answers", joinColumns = { @JoinColumn(name = "cand_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "quest_id") })
	private List<Answers> answers;

	public Question(String id, String question, String qnumber) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.question = question;
		setQnumber(qnumber);
	}

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		} catch (NumberFormatException | NullPointerException e) {
			// Do nothing - the value of id won't be changed
		}
	}

	public int getQnumber() {
		return qnumber;
	}

	public void setQnumber(int qnumber) {
		this.qnumber = qnumber;
	}
	public void setQnumber(String qnumber) {
		try {
			this.qnumber = Integer.parseInt(qnumber);
		} catch (NumberFormatException | NullPointerException e) {
			// Do nothing - the value of qnumber won't be changed
		}
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public Answers addAnswer(Answers answers) {
		getAnswers().add(answers);
		answers.setQuestion(this);

		return answers;
	}
}
