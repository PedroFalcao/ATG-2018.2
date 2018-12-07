package problema2;

import java.util.ArrayList;
import org.jgrapht.*;
import org.jgrapht.graph.*;

/**
 * This class builds the graph to answer the first proposed question.
 * 
 * @author Pedro Falcao
 *
 */
public class ProblemGraphBuilder2 {
	ArrayList<Subject2> elements;
	
	public ProblemGraphBuilder2() {
		this.elements = SourceAdapter2.instantiate();
	}
	
	ListenableGraph<String, DefaultEdge> createGraph() {
		ListenableGraph<String, DefaultEdge> graph = new DefaultListenableGraph<>(new DefaultUndirectedGraph<>(DefaultEdge.class));
		try {
			for (Subject2 s : elements) {
				graph.addVertex(s.getDenomination());
			}
			for (Subject2 subj : elements) {
				for (Subject2 otherSubj : elements) {
					if (subj.getJSExperience() >= otherSubj.getJSExperience() && !subj.getDenomination().equals(otherSubj.getDenomination())) {
						graph.addEdge(subj.getDenomination(), otherSubj.getDenomination());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return graph;
	}
}
