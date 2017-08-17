package crackingTheCodeInterview.recursion;

import java.util.LinkedList;
import java.util.Queue;

public class ex4_1 {

	public static void main(String[] args) {
		//3
		GraphNode node0 = new GraphNode(0);
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		GraphNode node5 = new GraphNode(5);
		node0.addAdjcentNodes(new GraphNode[]{node1, node4, node5});
		node1.addAdjcentNodes(new GraphNode[]{node3, node4});
		node2.addAdjcentNodes(new GraphNode[]{node1});
		node3.addAdjcentNodes(new GraphNode[]{node2, node4});
		Graph g = new Graph(node0, node1, node2, node3, node4, node5);
		g.clearVisited();
		System.out.println(node0);
		System.out.println(node1);
		System.out.println(node2);
		System.out.println(node3);
		System.out.println(node4);
		System.out.println(node5);
		System.out.println(pathExists(node5, node3));
	}
	
	public static class Graph{
		GraphNode[] nodes;
		
		public Graph(GraphNode... nodes){
			this.nodes = nodes;
		}

		public void clearVisited() {
			for (GraphNode g : nodes){
				g.visited = false;
			}
		}
	}
	
	public static class GraphNode{
		GraphNode[] adjcents;
		int value;
		boolean visited;
		public GraphNode(int value){
			this.value = value;
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
				sb.append(adjcents[i].value).append(",");
			}
			return sb.deleteCharAt(sb.length()-1).toString();
		}
	}
	
	public static boolean pathExists(GraphNode source, GraphNode dest){
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(source);
		source.visited = true;
		while(!queue.isEmpty()){
			GraphNode node = queue.remove();
			if(node.equals(dest)){
				return true;
			}
			if(node.adjcents != null){
				for(GraphNode child : node.adjcents){
					if(!child.visited){
						child.visited = true;
						queue.add(child);
					}
				}
			}
		}
		return false;
		
	}
}
