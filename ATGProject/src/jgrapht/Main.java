package jgrapht;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {
	private static final int INFO_COLUMN_QUANTITY = 4;
	private final static String FILE_ADDRESS = "src\\ATG.csv";

	public static void main(String[] args) {
		try {
			CSVFile file = CSVReader.read(FILE_ADDRESS);
			ArrayList<GenericSubject> subjects = new ArrayList<GenericSubject>();
			System.out.println("--======================================================================--");
			for (int i = 0; i < file.getYSize(); i++) {
				String[] line = file.getLine(i);
				if (line.length == INFO_COLUMN_QUANTITY) {
					subjects.add(new GenericSubject(line));
				}
			}
			System.out.println("     Quantidade de linhas lidas: " + subjects.size());
			System.out.println("--======================================================================--\n\n");
			System.out.println("Exemplos de linhas:\n\n");
			for (int index = 0; index < (subjects.size() > 10? 10 : subjects.size()); index++) {
				System.out.print(subjects.get(index).toString());
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
