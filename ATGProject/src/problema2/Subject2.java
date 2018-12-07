package problema2;

public class Subject2 {
	String denomination;
	int jsexperience;
	
	public Subject2(String denomination, int jsexperience) {
		this.denomination = denomination;
		this.jsexperience = jsexperience;
	}

	String getDenomination() {
		return denomination;
	}

	void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	int getJSExperience() {
		return jsexperience;
	}

	void setJSExperience(int jsexperience) {
		this.jsexperience = jsexperience;
	}
	
	public String toString() {
		return "Denomination: " + getDenomination() + "\n" + "Satisfaction with carreer: " + getJSExperience() + "\n";
	}

}
