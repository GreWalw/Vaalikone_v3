package data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the candidates database table.
 * 
 */
@Entity
@Table(name = "candidates")
@NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CANDIDATE_ID")
	private int candidateId;

	private int age;

	@Column(name = "CAND_NO")
	private int candNo;

	private String descr;

	@Column(name = "FIRST_NAME")
	private String firstName;

	private String hometown;

	private String party;

	private String profession;

	private String surname;

	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "candidate")
	private List<Answer> answers;

	public Candidate() {
	}

	public Candidate(String id, String surname, String firstname, String candNumb, String age, String hometown,
			String party, String profession, String description) {
		setId(id);
		this.surname = surname;
		this.firstName = firstname;
		setCandNo(candNumb);
		setAge(age);
		this.hometown = hometown;
		this.party = party;
		this.profession = profession;
		this.descr = description;
	}

	public int getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public void setId(String id) {
		try {
			this.candidateId = Integer.parseInt(id);
		} catch (NumberFormatException | NullPointerException e) {

		}
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void setAge(String age) {
		try {
			this.age = Integer.parseInt(age);
		} catch (NumberFormatException | NullPointerException e) {

		}
	}
	public int getCandNo() {
		return this.candNo;
	}

	public void setCandNo(int candNo) {
		this.candNo = candNo;
	}

	public void setCandNo(String candNo) {
		try {
			this.candNo = Integer.parseInt(candNo);
		} catch (NumberFormatException | NullPointerException e) {

		}
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getParty() {
		return this.party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setCandidate(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setCandidate(null);

		return answer;
	}

}