package problema2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import jgrapht.*;

/**
 * Esta classe adapta as informacoes recebidas na leitura do arquivo CSV de forma a serem usadas na construcao do grafo.
 * 
 * @author Pedro Falcao
 *
 */
public class SourceAdapter2 {
	public static ArrayList<Subject> instantiate() {
		try {
			// Workaround para descobrir o endereço do arquivo CSV.
			String[] vazio = new String[0];
			GenericSubject g = new GenericSubject(vazio);

			CSVFile file = CSVReader.read(g.getClass().getClassLoader().getResource("").getPath()+"ATG.csv");
			ArrayList<GenericSubject> gSubjects = new ArrayList<GenericSubject>();
			
			int lineSize = 10;
			for (int i = 0; i < file.getYSize(); i++) {
				String[] line = file.getLine(i);
				if (line.length == lineSize) {
					gSubjects.add(new GenericSubject(line));
				}
			}
			
			ArrayList<Subject> filteredSubjects = new ArrayList<Subject>();
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
