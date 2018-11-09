package jgrapht;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta classe prove um metodo para ler o arquivo cujo endereco completo foi passado como parametro.
 * 
 * @author Pedro Falcao
 *
 */
public final class CSVReader {
	public static CSVFile read(String address) throws FileNotFoundException {
		ArrayList<String> list = new ArrayList<String>();
		File file = new File(address);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			list.add(scanner.nextLine());
		}
		scanner.close();
		CSVFile f = new CSVFile(list);
		return f;
	}

}
