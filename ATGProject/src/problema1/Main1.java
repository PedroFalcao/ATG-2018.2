package problema1;

import java.util.ArrayList;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Main1 {
	private static Graph<String, DefaultWeightedEdge> graph;
	private static final int LIST_THIS_AMOUNT = 5;
	
	private Main1() {
		ProblemGraphBuilder1 pgb = new ProblemGraphBuilder1();
		Main1.graph = pgb.createGraph();
	}
	
	static int getHighestInDegreeValue() {
		int highest_in = 0;
		for (String vertex : graph.vertexSet()) {
			if (graph.inDegreeOf(vertex) > highest_in) {
				highest_in = graph.inDegreeOf(vertex);
			}
		} return highest_in;
	}
	
	static int getLowestInDegreeValue() {
		int lowest_in = 100;
		for (String vertex : graph.vertexSet()) {
			if (graph.inDegreeOf(vertex) < lowest_in) {
				lowest_in = graph.inDegreeOf(vertex);
			}
		} return lowest_in;
	}
	
	static int getHighestOutDegreeValue() {
		int highest_out = 0;
		for (String vertex : graph.vertexSet()) {
			if (graph.outDegreeOf(vertex) > highest_out) {
				highest_out = graph.outDegreeOf(vertex);
			}
		} return highest_out;
	}
	
	static int getLowestOutDegreeValue() {
		int lowest_out = 100;
		for (String vertex : graph.vertexSet()) {
			if (graph.outDegreeOf(vertex) < lowest_out) {
				lowest_out = graph.outDegreeOf(vertex);
			}
		} return lowest_out;
	}
	
	static ArrayList<String> mostExperienced(int amountOfIndividuals) {
		ArrayList<String> list = new ArrayList<String>();
		int value = getLowestOutDegreeValue();
		while(list.size() < amountOfIndividuals && list.size() < graph.vertexSet().size()) {
			for (String vertex : graph.vertexSet()) {
				if (graph.outDegreeOf(vertex) == value) {
					list.add(vertex);
				}
				if (list.size() >= amountOfIndividuals) {
					return list;
				}
			} value++;
		}
		return list;
	}
	
	static ArrayList<String> mostExperienced() {
		ArrayList<String> list = new ArrayList<String>();
		int value = getLowestOutDegreeValue();
		for (String vertex : graph.vertexSet()) {
			if (graph.outDegreeOf(vertex) == value) {
				list.add(vertex);
			}
		}
		return list;
	}
	
	static ArrayList<String> leastExperienced(int amountOfIndividuals) {
		ArrayList<String> list = new ArrayList<String>();
		int value = getLowestInDegreeValue();
		while(list.size() < amountOfIndividuals && list.size() < graph.vertexSet().size()) {
			for (String vertex : graph.vertexSet()) {
				if (graph.inDegreeOf(vertex) == value) {
					list.add(vertex);
				}
				if (list.size() >= amountOfIndividuals) {
					return list;
				}
			} value++;
		}
		return list;
	}
	
	static ArrayList<String> leastExperienced() {
		ArrayList<String> list = new ArrayList<String>();
		int value = getLowestInDegreeValue();
		for (String vertex : graph.vertexSet()) {
			if (graph.inDegreeOf(vertex) == value) {
				list.add(vertex);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		new Main1();
		System.out.println("--=========================================================================================================--");
		System.out.println("Metodologia: Os desenvolvedores escolhidos precisam saber JavaScript e ter a maior experiencia na linguagem.");
		System.out.println("             Existem relações entre os vértices quando um é menor que o outro. As arestas tem peso dado pela diferenca entre a experiencia dos vertices.");
		System.out.println("O grafo tem " + graph.vertexSet().size() + " desenvolvedores no dominio escolhido (desenvolvedores que sabem JavaScript)");
		ArrayList<String> most = mostExperienced(LIST_THIS_AMOUNT);
		ArrayList<String> least = leastExperienced(LIST_THIS_AMOUNT);
		
		System.out.println("Maxima quantidade de arestas chegando: " + getHighestInDegreeValue());
		System.out.println("Minima quantidade de arestas chegando: " + getLowestInDegreeValue());
		System.out.println("Maxima quantidade de arestas saindo: " + getHighestOutDegreeValue());
		System.out.println("Minima quantidade de arestas saindo: " + getLowestOutDegreeValue());
		System.out.println("Os mais experientes sao " + mostExperienced().size() + " ao todo.");
		System.out.println("Os menos experientes sao " + leastExperienced().size() + " ao todo.");
		System.out.println("Os " + LIST_THIS_AMOUNT + " mais experientes desenvolvedores sao: ");
		for (String s1 : most) {
			System.out.println("     > > > " + s1);
		}
		System.out.println("Os " + LIST_THIS_AMOUNT + " menos experientes desenvolvedores sao: ");
		for (String s2 : least) {
			System.out.println("     > > > " + s2);
		}
	}
}