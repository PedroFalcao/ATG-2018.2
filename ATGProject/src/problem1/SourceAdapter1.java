package problem1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jgrapht.*;


/**
 * Esta classe adapta as informacoes recebidas na leitura do arquivo CSV de forma a serem usadas na construcao do grafo. Isto inclui filtrar as colunas nao-relevantes e organizar os vertices como sendo os paises, no lugar de serem os usu�rios.
 * 
 * @author Pedro Falcao
 *
 */
public class SourceAdapter1 {
	public static Map<String, Integer> instantiate() {
		try {
			// Workaround para descobrir o endereço do arquivo CSV.
			String[] vazio = new String[0];
			GenericSubject g = new GenericSubject(vazio);
			
			
			CSVFile file = CSVReader.read(g.getClass().getClassLoader().getResource("").getPath()+"ATG.csv");
			ArrayList<GenericSubject> gSubjects = new ArrayList<GenericSubject>();
			
			// No arquivo especifico lido, os dados dos usuarios comecam a ser mostrados a partir da decima linha.
			int lineSize = 10;
			for (int i = 0; i < file.getYSize(); i++) {
				String[] line = file.getLine(i);
				if (line.length == lineSize) {
					gSubjects.add(new GenericSubject(line));
				}
			}
			
			// Filtro para reter os usuarios que nao opinaram sobre a satisfacao de sua profissao.
			ArrayList<Subject> filteredSubjects = new ArrayList<Subject>();
			for (int j = 0; j < gSubjects.size(); j++) {
				GenericSubject gs = gSubjects.get(j);
				if (!gs.get(8).equals("NA")) {
					filteredSubjects.add(new Subject(gs.get(1),Integer.parseInt(gs.get(8))));
				}
			}
			Map<String, Integer> satisfaction = new HashMap<String, Integer>();
			Map<String, Integer> numberOfSubjects = new HashMap<String, Integer>();
			
			// Calcular as medias de cada pais.
			for (Subject s : filteredSubjects) {
				satisfaction.put(s.getCountry(), 0);
				numberOfSubjects.put(s.getCountry(),0);
			}
			for (Subject s : filteredSubjects) {
				satisfaction.put(s.getCountry(), satisfaction.get(s.getCountry()) + s.getSatisfaction());
				numberOfSubjects.put(s.getCountry(), numberOfSubjects.get(s.getCountry()) + 1);
			}
			for (String str : satisfaction.keySet()) {
				satisfaction.put(str, satisfaction.get(str)/numberOfSubjects.get(str));
			}
			
			return satisfaction;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
