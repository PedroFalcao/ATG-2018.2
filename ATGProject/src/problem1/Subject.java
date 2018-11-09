package problem1;

/**
 * Esta classe apenas serve para organizar as informações recebidas do arquivo CSV.
 * 
 * @author Pedro Falcao
 *
 */
public class Subject {
	String country;
	int satisfaction;
	
	public Subject(String country, int satisfaction) {
		this.country = country;
		this.satisfaction = satisfaction;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}
	
	public String toString() {
		return "Country: " + country + "\n" + "Satisfaction with carreer: " + satisfaction + "\n";
	}

}
