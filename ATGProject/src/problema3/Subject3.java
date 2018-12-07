package problema3;

import java.util.ArrayList;

public class Subject3 {
	private String denomination;
	private String country;
	private ArrayList<String> known_languages;
	
	public Subject3(String denomination, String country, ArrayList<String> known_languages) {
		this.denomination = denomination;
		this.country = country;
		this.known_languages = known_languages;
	}

	String getDenomination() {
		return denomination;
	}

	void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	String getCountry() {
		return country;
	}

	void setCountry(String country) {
		this.country = country;
	}

	ArrayList<String> getKnownLanguages() {
		return known_languages;
	}

	void setKnownLanguages(ArrayList<String> known_languages) {
		this.known_languages = known_languages;
	}
	
	public String toString() {
		String ret = "Denomination: " + getDenomination() + "\n" + "Country: " + getCountry() + "\n";
		ret = ret + "Languages Known: ";
		for (String lang : known_languages) {
			ret = ret + lang + "; ";
		}
		return ret;
	}

}
