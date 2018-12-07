package problema1alt;

import java.util.ArrayList;
import org.jgrapht.graph.*;

/**
 * This class builds the graph to answer the first proposed question.
 * 
 * @author Pedro Falcao
 *
 */
public class ProblemGraphBuilder1 {
	ArrayList<Subject1> elements;
	
	public ProblemGraphBuilder1() {
		this.elements = SourceAdapter1.instantiate();
	}
	
	SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> createGraph() {
		SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>  graph = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		try {
			for (Subject1 s : elements) {
				graph.addVertex(s.getDenomination());
			}
			for (Subject1 subj : elements) {
				for (Subject1 otherSubj : elements) {
					if (subj.getExperience() < otherSubj.getExperience()) {
						DefaultWeightedEdge weighted_edge = graph.addEdge(subj.getDenomination(), otherSubj.getDenomination());
			            graph.setEdgeWeight(weighted_edge, (otherSubj.getExperience() - subj.getExperience()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return graph;
	}
}
