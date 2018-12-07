package problem1;

import java.util.ArrayList;
import org.jgrapht.*;
import org.jgrapht.graph.*;

/**
 * This class builds the graph to answer the first proposed question.
 * 
 * @author Pedro Falcao
 *
 */
public class ProblemGraphBuilder1 {
	ArrayList<Subject> elements;
	
	public ProblemGraphBuilder1() {
		this.elements = SourceAdapter1.instantiate();
	}
	
	ListenableGraph<String, DefaultEdge> createGraph() {
		ListenableGraph<String, DefaultEdge> graph = new DefaultListenableGraph<>(new DefaultUndirectedGraph<>(DefaultEdge.class));
		try {
			for (Subject s : elements) {
				graph.addVertex(s.getDenomination());
			}
			for (Subject subj : elements) {
				for (Subject otherSubj : elements) {
					if (subj.getExperience() == otherSubj.getExperience() && !subj.getDenomination().equals(otherSubj.getDenomination())) {
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
