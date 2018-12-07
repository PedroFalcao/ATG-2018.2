package problema3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import jgrapht.*;


/**
 * Esta classe adapta as informações recebidas na leitura do arquivo CSV de forma a serem usadas na construção do grafo. Isto inclui filtrar as colunas não-relevantes e organizar os vértices como sendo os países, no lugar de serem os usuários.
 * 
 * @author Pedro Falcao
 *
 */
public class SourceAdapter3{
	private final static int LINE_SIZE = 4; // Essa constante aponta quantas colunas os dados tem, no CSV.  
	private final static int USEFUL_DATA_INDEX = 0; // Indica em que coluna do CSV a informacao esta.
	private final static int USEFUL_DATA_INDEX_2 = 3;
	private final static String FILE_ADDRESS = "src\\ATG.csv"; // Vai indicar o endereco do arquivo CSV de onde sera extraida a informacao.
	
	
	// Esse metodo nao eh muito intuitivo, mas ele basicamente pega do CSV apontado pelo endereco da constante FILE_ADDRESS a informacao que estiver na posicao USEFUL_DATA_INDEX e coloca em um objeto "Subject" para ser mais facilmente trabalhado. 
	public static HashMap<String,ArrayList<Subject3>> instantiate() {
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
			HashMap<String,ArrayList<Subject3>> countries = new HashMap<String,ArrayList<Subject3>>(); 
			for (int j = 0; j < gSubjects.size(); j++) {
				GenericSubject gs = gSubjects.get(j);
				String country = gs.get(USEFUL_DATA_INDEX);
				ArrayList<String> known_langs = new ArrayList<String>(Arrays.asList(gs.get(USEFUL_DATA_INDEX_2).split("; ")));
				Subject3 subject = new Subject3 ("Desenvolvedor " + j, country, known_langs);
				if (countries.containsKey(country)) {
					countries.get(country).add(subject);
				} else {
					ArrayList<Subject3> new_list = new ArrayList<Subject3>();
					new_list.add(subject);
					countries.put(country, new_list);
				}
			}
			
			return countries;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}

