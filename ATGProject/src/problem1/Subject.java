package problem1;

/**
 * Esta classe apenas serve para organizar as informacoes recebidas do arquivo CSV.
 * 
 * @author Pedro Falcao
 *
 */
public class Subject {
	String denomination;
	int experience;
	
	public Subject(String denomination, int experience) {
		this.denomination = denomination;
		this.experience = experience;
	}

	String getDenomination() {
		return denomination;
	}

	void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	int getExperience() {
		return experience;
	}

	void setExperience(int experience) {
		this.experience = experience;
	}
	
	public String toString() {
		return "Denomination: " + denomination + "\n" + "Experience in carreer: " + experience + "\n";
	}

}
