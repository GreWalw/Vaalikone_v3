package data;

public class Candidates {
	private int id;
	private String surname;
	private String firstname;
	private int candNumb;
	private int age;
	private String hometown;
	private String party;
	private String profession;
	private String description;

	public Candidates(String id, String surname, String firstname, String candNumb, String age, String hometown, String party,
			String profession, String description) {
		setId(id);
		this.surname=surname;
		this.firstname=firstname;
		setCandNumb(candNumb);
		setAge(age);
		this.hometown=hometown;
		this.party=party;
		this.profession=profession;
		this.description=description;
	}

	public Candidates() {

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

		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getCandNumb() {
		return candNumb;
	}

	public void setCandNumb(int candNumb) {
		this.candNumb = candNumb;
	}

	public void setCandNumb(String candNumb) {
		try {
			this.candNumb = Integer.parseInt(candNumb);
		} catch (NumberFormatException | NullPointerException e) {

		}
	}

	public int getAge() {
		return age;
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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
