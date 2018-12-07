package jgrapht;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Esta classe serve para organizar uma linha lida do CSV sem nenhuma formatação específica.
 * 
 * @author Pedro Falcao
 *
 */
public class GenericSubject {
	private ArrayList<String> info;
	
	public GenericSubject(String[] info) {
		this.info = new ArrayList<String>();
		this.info.addAll(Arrays.asList(info));
	}
	
	public String get(int index) {
		return info.get(index);
	}
	
	
	@Override
	public String toString() {
		String ret = "";
		ret = ret.concat("===== Subject ===============\n");
		for (int i = 0; i < info.size(); i++) {
			ret = ret.concat(info.get(i) + "\n");
		}
		ret = ret.concat("=============================\n");
		return ret;
	}

}
