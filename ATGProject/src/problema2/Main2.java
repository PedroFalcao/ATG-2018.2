package problema2;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class Main2 {
	public static void main(String[] args) {
		ProblemGraphBuilder2 pgb = new ProblemGraphBuilder2();
		Graph<String, DefaultEdge> graph = pgb.createGraph();
		System.out.println("--=========================================================================================================--");
		System.out.println("Metodologia: Os desenvolvedores escolhidos precisam saber JavaScript e ter a maior experiencia na linguagem");
		System.out.println("O grafo tem " + graph.vertexSet().size() + " desenvolvedores no dominio escolhido (desenvolvedores que sabem JavaScript)");
		System.out.println("Os melhores desenvolvedores tem");
	}
}
