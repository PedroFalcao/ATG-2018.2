package problema2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import jgrapht.*;


/**
 * Esta classe adapta as informa��es recebidas na leitura do arquivo CSV de forma a serem usadas na constru��o do grafo. Isto inclui filtrar as colunas n�o-relevantes e organizar os v�rtices como sendo os pa�ses, no lugar de serem os usu�rios.
 * 
 * @author Pedro Falcao
 *
 */
public class SourceAdapter2{
	private final static int LINE_SIZE = 4; // Essa constante aponta quantas colunas os dados tem, no CSV.  
	private final static int USEFUL_DATA_INDEX = 2; // Indica em que coluna do CSV a informacao esta.
	private final static int USEFUL_DATA_INDEX_2 = 3;
	private final static String FILE_ADDRESS = (System.getProperty("os.name").equals("Linux")? "src/ATG.csv" : "src\\ATG.csv"); // Vai indicar o endereco do arquivo CSV de onde sera extraida a informacao.
	
	
	
	// Esse metodo nao eh muito intuitivo, mas ele basicamente pega do CSV apontado pelo endereco da constante FILE_ADDRESS a informacao que estiver na posicao USEFUL_DATA_INDEX e coloca em um objeto "Subject" para ser mais facilmente trabalhado. 
	public static ArrayList<Subject2> instantiate() {
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
			ArrayList<Subject2> filteredSubjects = new ArrayList<Subject2>();
			for (int j = 0; j < gSubjects.size(); j++) {
				GenericSubject gs = gSubjects.get(j);
				String years_experience = gs.get(USEFUL_DATA_INDEX);
				if (gs.get(USEFUL_DATA_INDEX_2).contains("JavaScript")) { // Somente os que trabalharam em JavaScript
					if (years_experience.startsWith("Le") || years_experience.startsWith("NA")) {
						filteredSubjects.add(new Subject2("Desenvolvedor " + j,0));
					} else {
						filteredSubjects.add(new Subject2("Desenvolvedor " + j,Integer.parseInt(years_experience.substring(0, 2).trim())));
					}
				}
			}
			
			return filteredSubjects;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
