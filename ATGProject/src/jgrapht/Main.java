package jgrapht;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		try {
			CSVFile file = CSVReader.read("C:\\Users\\pedro\\Downloads\\ATG - Página1.csv");
			ArrayList<GenericSubject> subjects = new ArrayList<GenericSubject>();
			//System.out.println("======================================================================");
			int lineSize = 10;
			for (int i = 0; i < file.getYSize(); i++) {
				String[] line = file.getLine(i);
				if (line.length == lineSize) {
					subjects.add(new GenericSubject(line));
				}
			}
			//System.out.println(subjects.size());
			for (int j = 0; j < subjects.size(); j++) {
				subjects.get(j).toString();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
