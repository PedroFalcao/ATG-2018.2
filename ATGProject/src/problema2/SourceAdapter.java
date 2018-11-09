package problema2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jgrapht.*;

public class SourceAdapter {
	public static ArrayList<Subject> instantiate() {
		try {
			CSVFile file = CSVReader.read("src\\ATG.csv");
			ArrayList<GenericSubject> gSubjects = new ArrayList();
			
			int lineSize = 10;
			for (int i = 0; i < file.getYSize(); i++) {
				String[] line = file.getLine(i);
				if (line.length == lineSize) {
					gSubjects.add(new GenericSubject(line));
				}
			}
			
			ArrayList<Subject> filteredSubjects = new ArrayList();
			for (int j = 0; j < gSubjects.size(); j++) {
				GenericSubject gs = gSubjects.get(j);
				if (!gs.get(8).equals("NA")) {
					filteredSubjects.add(new Subject(gs.get(1),gs.get(2)));
				}
			}
			
			return filteredSubjects;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
