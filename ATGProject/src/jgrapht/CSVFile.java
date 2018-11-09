package jgrapht;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Esta classe serve como Wrapper para o arquivo lido do CSV.
 * 
 * @author Pedro Falcao
 *
 */
public class CSVFile {
	private ArrayList<String[]> lines;
	
	public CSVFile(ArrayList<String> list) {
		lines = new ArrayList<String[]>();
		for (int i = 0; i < list.size(); i++) {
			lines.add(list.get(i).split(","));
		}
	}
	
	/**
	 * Metodo para analisar quantas linhas o arquivo lido possui.
	 * 
	 * @return um inteiro com a quantidade de linhas contidas no arquivo.
	 */
	public int getYSize() {
		return lines.size();
	}
	
	/**
	 * Este método procura pela linha com mais colunas no arquivo.
	 * 
	 * @return A maior quantidade de colunas presente em uma linha.
	 */
	public int getXSize() {
		int maxSize = 0;
		for (int j = 0; j < lines.size(); j++) {
			if (lines.get(j).length > maxSize) {
				maxSize = lines.get(j).length;
			}
		}
		return maxSize;
	}
	
	@Override
	public String toString() {
		String ret = "";
		for (int k = 0; k < lines.size(); k++) {
			ret.concat(Arrays.toString(lines.get(k)));
		}
		return ret;
	}
	
	public String[] getLine(int index) {
		return lines.get(index);
	}
}
