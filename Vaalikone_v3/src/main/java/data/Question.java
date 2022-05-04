package data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name="questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="QUESTION_ID")
	private int questionId;

	private String question;

	@Column(name="QUESTION_NUMBER")
	private int questionNumber;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

	public Question() {
	}

	public Question(String id, String question, String qnumber) {
		setQuestionId(id);
		this.question = question;
		setQuestionNumber(qnumber);
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public void setQuestionId(String questionId) {
		try {
			this.questionId = Integer.parseInt(questionId);
		} catch (NumberFormatException | NullPointerException e) {

		}
	}
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getQuestionNumber() {
		return this.questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public void setQuestionNumber(String questionNumber) {
		try {
			this.questionNumber = Integer.parseInt(questionNumber);
		} catch (NumberFormatException | NullPointerException e) {

		}
	}
	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setQuestion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setQuestion(null);

		return answer;
	}
  
	public String toString() {
		return "Question: "+this.questionId;
	}

}