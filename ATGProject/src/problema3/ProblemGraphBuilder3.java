package problema3;

import java.util.ArrayList;
import java.util.HashMap;

import org.jgrapht.*;
import org.jgrapht.graph.*;

/**
 * This class builds the graph to answer the first proposed question.
 * 
 * @author Pedro Falcao
 *
 */
public class ProblemGraphBuilder3 {
	final static double POPULARITY_RATIO = 0.2;
	final static int COUNTRY_RELATION_RATIO = 6;
	private HashMap<String,ArrayList<Subject3>> elements;
	private HashMap<String,ArrayList<String>> refinedElements;
	
	public ProblemGraphBuilder3() {
		this.elements = SourceAdapter3.instantiate();
		this.refinedElements = this.refineElements();
	}
	
	
	/*
	 * This very convoluted and hard-to-understand method basically transforms the map of developers (elements) per country (key) into a map of languages (elements) per country (key). This lets us quantify the relations between the countries. 
	 */
	private HashMap<String, ArrayList<String>> refineElements() {
		HashMap<String, ArrayList<String>> langs_per_country = new HashMap<String, ArrayList<String>>();
		for (String country : elements.keySet()) {
			HashMap<String, Integer> devs_per_lang = new HashMap<String, Integer>();
			ArrayList<Subject3> devs = elements.get(country);
			for (Subject3 subj : devs) {
				for (String lang : subj.getKnownLanguages()) {
					if (devs_per_lang.containsKey(lang)) {
						devs_per_lang.put(lang, devs_per_lang.get(lang) + 1);
					} else {
						devs_per_lang.put(lang, 1);
					}
				}
			}
			for (String language : devs_per_lang.keySet()) {
				if (devs_per_lang.get(language) >= (devs.size() * POPULARITY_RATIO)) {
					if (langs_per_country.containsKey(country)) {
						langs_per_country.get(country).add(language);
					} else {
						ArrayList<String> new_list = new ArrayList<String>();
						new_list.add(language);
						langs_per_country.put(country, new_list);
					}
				}
			}
		} return langs_per_country;
	}
	
	ListenableGraph<String, DefaultEdge> createGraph() {
		ListenableGraph<String, DefaultEdge> graph = new DefaultListenableGraph<>(new DefaultUndirectedGraph<>(DefaultEdge.class));
		try {
			for (String country : refinedElements.keySet()) { // Povoa o grafo com vertices
				graph.addVertex(country);
			}
			for (String country : refinedElements.keySet()) {
				for (String country2 : refinedElements.keySet()) { // Comparar os dois paises
					int langs_in_common = 0;
					for (String lang : refinedElements.get(country)) {
						if (refinedElements.get(country2).contains(lang)) { // Se houver a mesma linguagem popular em cada um dos paises, incrementa o contador
							langs_in_common++;
						}
					} if (langs_in_common >= COUNTRY_RELATION_RATIO) { // Se houverem mais de 4 linguagens populares em comum, adicione uma aresta
						graph.addEdge(country, country2);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return graph;
	}
}
