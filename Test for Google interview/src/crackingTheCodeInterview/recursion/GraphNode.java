package crackingTheCodeInterview.recursion;

import crackingTheCodeInterview.recursion.ex4_0.GraphNode;
import crackingTheCodeInterview.recursion.ex4_0.VisitStatus;

class GraphNode2 extends  GraphNode{
	public GraphNode2(int value){
		super(value);
		vs = VisitStatus.NOT_VISITED;
		adjcents[0] =null;
	}
}