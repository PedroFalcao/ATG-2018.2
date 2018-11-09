package problema2;

public class Subject {
	String country;
	String education;
	
	public Subject(String country, String education) {
		this.country = country;
		this.education = education;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	public String toString() {
		return "Country: " + getCountry() + "\n" + "Satisfaction with carreer: " + getEducation() + "\n";
	}

}
