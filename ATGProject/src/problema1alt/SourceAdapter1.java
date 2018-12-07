package problema1alt;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import jgrapht.*;


/**
 * Esta classe adapta as informações recebidas na leitura do arquivo CSV de forma a serem usadas na construção do grafo. Isto inclui filtrar as colunas não-relevantes e organizar os vértices como sendo os países, no lugar de serem os usuários.
 * 
 * @author Pedro Falcao
 *
 */
public class SourceAdapter1 {
	private final static int LINE_SIZE = 4; // Essa constante aponta quantas colunas os dados tem, no CSV.  
	private final static int USEFUL_DATA_INDEX = 1; // Indica em que coluna do CSV a informacao esta.
	private final static String FILE_ADDRESS = "src\\ATG.csv"; // Vai indicar o endereco do arquivo CSV de onde sera extraida a informacao.
	
	
	// Esse metodo nao eh muito intuitivo, mas ele basicamente pega do CSV apontado pelo endereco da constante FILE_ADDRESS a informacao que estiver na posicao USEFUL_DATA_INDEX e coloca em um objeto "Subject" para ser mais facilmente trabalhado. 
	public static ArrayList<Subject1> instantiate() {
		try {
			CSVFile file = CSVReader.read(FILE_ADDRESS);
			ArrayList<GenericSubject> gSubjects = new ArrayList<GenericSubject>();
			
			// No arquivo especifico lido, os dados dos usuarios comecam a ser mostrados a partir da decima linha, e possuem uma quantidade fixa de colunas.
			for (int i = 0; i < file.getYSize(); i++) {
				String[] line = file.getLine(i);
				if (line.length == LINE_SIZE) {
					gSubjects.add(new GenericSubject(line));
				}
			}
			
			// Filtro para reter apenas o valor numerico dos anos de experiencia.
			ArrayList<Subject1> filteredSubjects = new ArrayList<Subject1>();
			for (int j = 0; j < gSubjects.size(); j++) {
				GenericSubject gs = gSubjects.get(j);
				String years_experience = gs.get(USEFUL_DATA_INDEX);
				if (years_experience.startsWith("Le") || years_experience.startsWith("NA")) {
					filteredSubjects.add(new Subject1("Desenvolvedor " + j,0));
				} else {
					filteredSubjects.add(new Subject1("Desenvolvedor " + j,Integer.parseInt(years_experience.substring(0, 2).trim())));
				}
			}
			
			return filteredSubjects;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
