package problem1;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Esta classe é usada apenas para analisar os grafos gerados pela linha de comando.
 * 
 * @author Pedro Falcao
 *
 */
public class Main1 {
	public static void main(String[] args) {
		ProblemGraphBuilder1 pgb = new ProblemGraphBuilder1();
		Graph<String, DefaultEdge> graph = pgb.createGraph();
		System.out.println(graph);
		System.out.println(graph.edgesOf("Desenvolvedor 1"));
	}
}
