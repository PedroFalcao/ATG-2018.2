package problema3;

import java.util.ArrayList;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class Main3 {
	private static Graph<String, DefaultEdge> graph;
	
	private Main3() {
		ProblemGraphBuilder3 pgb = new ProblemGraphBuilder3();
		Main3.graph = pgb.createGraph();
	}
	
	private static int maiorGrau() {
		int maior_atual = 0;
		
		for (String vertice : graph.vertexSet()) {
			if (maior_atual < graph.degreeOf(vertice)) {
				maior_atual = graph.degreeOf(vertice);
			}
		} return maior_atual;
	}
	
	private static ArrayList<String> verticesComMaiorGrau() {
		ArrayList<String> resultado = new ArrayList<String>();
		int grau = maiorGrau();
		for (String vertice : graph.vertexSet()) {
			if (graph.degreeOf(vertice) == grau) {
				resultado.add(vertice);
			}
		} return resultado;
	}
	
	public static void main(String[] args) {
		new Main3();
		System.out.println(graph + "\n");
//		for (String de : graph.vertexSet()) {
//			System.out.println("Nome do pais: " + de);
//			System.out.println("Grau do pais: " + graph.degreeOf(de.toString()) + "\n");
//		}
		
		
		ArrayList<String> maioresGraus = verticesComMaiorGrau();
		System.out.println("--=========================================================================================================--");
		System.out.println("Metodologia: Para uma linguagem ser popular em um pais, ela precisa ser conhecida por " + (Double.valueOf(ProblemGraphBuilder3.POPULARITY_RATIO*100)).intValue() + "% dos desenvolvedores");
		System.out.println("             Os paises possuem relacao se possuem " + ProblemGraphBuilder3.COUNTRY_RELATION_RATIO + " ou mais linguagens populares em comum\n");
		System.out.println("O grafo tem " + graph.vertexSet().size() + " paises no dominio escolhido.");
		System.out.println("O maior grau eh: " + maiorGrau());
		System.out.println("O(s) pais(es) de maior grau eh(sao):");
		for (String vertice : maioresGraus) {
			System.out.println("    > > > " + vertice);
		}
		System.out.println("--=========================================================================================================--");
	}
}