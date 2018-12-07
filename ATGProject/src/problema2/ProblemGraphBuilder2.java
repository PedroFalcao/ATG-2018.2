package problema2;

import java.util.ArrayList;
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
	
	SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> createGraph() {
		SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>  graph = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		try {
			for (Subject2 s : elements) {
				graph.addVertex(s.getDenomination());
			}
			for (Subject2 subj : elements) {
				for (Subject2 otherSubj : elements) {
					if (subj.getJSExperience() < otherSubj.getJSExperience()) {
						DefaultWeightedEdge weighted_edge = graph.addEdge(subj.getDenomination(), otherSubj.getDenomination());
			            graph.setEdgeWeight(weighted_edge, (otherSubj.getJSExperience() - subj.getJSExperience()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return graph;
	}
}

