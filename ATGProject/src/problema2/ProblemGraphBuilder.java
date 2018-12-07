package problema2;

import java.util.ArrayList;
import org.jgrapht.*;
import org.jgrapht.graph.*;

/**
 * This class builds the graph to answer the second proposed question.
 * 
 * @author Pedro Falcao
 *
 */
public class ProblemGraphBuilder {
	ArrayList<Subject> elements;
	
	public ProblemGraphBuilder() {
		this.elements = SourceAdapter2.instantiate();
	}
	
	public Graph<String, DefaultEdge> createGraph() {
		Graph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);
		try {
			for (Subject s : elements) {
				graph.addVertex(s.getCountry());
			}
			for (Subject subject : elements) {
				for (Subject otherSubject: elements) {
					graph.addEdge(subject.getCountry(), otherSubject.getCountry());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return graph;
	}
}
