package crackingTheCodeInterview.recursion;

import java.util.LinkedList;
import java.util.Queue;

import crackingTheCodeInterview.recursion.ex4_0.VisitStatus;
import crackingTheCodeInterview.recursion.ex4_2.Node;

public class ex4_0 {

	public static void main(String[] args) {
		//3
		GraphNode node0 = new GraphNode(0);
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		GraphNode node5 = new GraphNode(5);
		node0.addAdjcentNodes(new GraphNode[]{node1, node4, node5});
		node1.addAdjcentNodes(new GraphNode[]{node3, node4, node0});
		node2.addAdjcentNodes(new GraphNode[]{node1});
		node3.addAdjcentNodes(new GraphNode[]{node2, node4});
		System.out.println(node0);
		System.out.println(node1);
		System.out.println(node2);
		System.out.println(node3);
		System.out.println(node4);
		System.out.println(node5);
		Graph g = new Graph(node0, node1, node2, node3, node4, node5);
		g.clearVisited();
		dfsSearch(node0);
		g.clearVisited();
		System.out.println();
		bfsSearch(node0);
	}
	
	static class GraphNode{
		GraphNode[] adjcents;
		int value;
		VisitStatus vs;
		boolean visited;
		public GraphNode(int value){
			this.value = value;
			vs = VisitStatus.NOT_VISITED;
			this.adjcents = new GraphNode[1];
		}
		public void addAdjcentNodes(GraphNode[] adjcents){
			this.adjcents = adjcents;
		}
		
		
		@Override
		public String toString() {
			return value + ": " + printAdjcents();
		}
		
		public String printAdjcents(){
			if(adjcents == null){
				return null;
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < adjcents.length; i++){
				if(adjcents[i] != null){
					sb.append(adjcents[i].value).append(",");
				}
			}
			if(sb.length() > 0){
				sb.deleteCharAt(sb.length()-1);
			}
			return sb.toString();
		}
	}
	public static class Graph{
		GraphNode[] nodes;
		
		public Graph(GraphNode... nodes){
			this.nodes = nodes;
		}

		public void clearVisited() {
			for (GraphNode g : nodes){
				g.visited = false;
				if(g instanceof GraphNode2){
					((GraphNode2)g).vs = VisitStatus.NOT_VISITED;
				}
			}
		}
	}
	
	static enum VisitStatus{
		VISITED,
		VISITING,
		NOT_VISITED
	}
	
	
	public static void dfsSearch(GraphNode root){
		if(root == null){
			return;
		}
		visit(root);
		root.visited = true;
		if(root.adjcents != null){
			for(GraphNode node : root.adjcents){
				if(node != null && !node.visited){
					dfsSearch(node);
				}
			}
		}
	}

	private static void visit(GraphNode root) {
		System.out.print(root.value + "-> ");
	}

	public static void bfsSearch(GraphNode root){
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			GraphNode node = queue.remove();
			if(node.adjcents != null){
				for(GraphNode child : node.adjcents){
					if(child != null && !child.visited){
						queue.add(child);
						child.visited = true;
					}
				}
			}
			visit(node);
			node.visited = true;
		}
	}
	
	public static int getBiTreeHeight(Node root){
		if(root == null){
			return 0;
		}
		return Math.max(getBiTreeHeight(root.left), getBiTreeHeight(root.right))+1;
	}
}
