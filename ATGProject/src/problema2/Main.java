package problema2;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class Main {
	public static void main(String[] args) {
		ProblemGraphBuilder pgb = new ProblemGraphBuilder();
		Graph<String, DefaultEdge> graph = pgb.createGraph();
		System.out.println(graph);
	}
}
