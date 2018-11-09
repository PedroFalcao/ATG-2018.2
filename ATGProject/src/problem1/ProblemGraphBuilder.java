package problem1;

import java.util.Map;
import java.util.Set;

import org.jgrapht.*;
import org.jgrapht.graph.*;

/**
 * This class builds the graph to answer the first proposed question.
 * 
 * @author Pedro Falcao
 *
 */
public class ProblemGraphBuilder {
	Map<String,Integer> elements;
	
	public ProblemGraphBuilder() {
		this.elements = SourceAdapter1.instantiate();
	}
	
	ListenableGraph<String, DefaultEdge> createGraph() {
		ListenableGraph<String, DefaultEdge> graph = new DefaultListenableGraph<>(new DefaultUndirectedGraph<>(DefaultEdge.class));
		try {
			Set<String> keys = elements.keySet();
			for (String str : keys) {
				graph.addVertex(str);
			}
			for (String key : keys) {
				for (String otherKey : keys) {
					if (!key.equals(otherKey)) {
						if (elements.get(key).equals(elements.get(otherKey))) {
							graph.addEdge(key, otherKey);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return graph;
	}
}
