package crackingTheCodeInterview.recursion;

import java.util.*;

public class GInterviewFuckUp {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addCity("a", "b");
		g.addCity("a", "c");
		g.addCity("a", "d");
		g.addCity("b", "c");
		g.addCity("d", "e");
		
		System.out.println(g.isConnected("e", "a"));

	}
	
	static class Graph {
		private Map<String, Node> nodes = new HashMap<>();

		public void addCity(String a, String b) {
			Node nodeA = nodes.get(a);
			if (nodeA == null) {
				nodeA = new Node(a);
				nodes.put(a, nodeA);
			}

			Node nodeB = nodes.get(b);
			if (nodeB == null) {
				nodeB = new Node(b);
				nodes.put(b, nodeB);
			}

			nodeA.addAdjcent(nodeB);
			nodeB.addAdjcent(nodeA);
		}

		public boolean isConnected(String a, String b) {
			if (a == null || b == null) {
				return false;
			}
			Node root = nodes.get(a);
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			root.setVisited(true);
			while (!q.isEmpty()) {
				Node currentNode = q.remove();
				if (currentNode.getName().equals(b)) {
					return true;
				}
				for (Node adj : currentNode.getAdjcents().values()) {
					if (!adj.isVisited()) {
						q.add(adj);
						adj.setVisited(true);
					}
				}
			}
			return false;
		}
	}


	static class Node{
	  private Map<String, Node> adjcents = new HashMap<>();
	  private String name;
	  private boolean visited;
	  
	  public Node(String name){
	    this.name = name;
	  }

	  public void addAdjcent(Node adjcent){
	    adjcents.put(adjcent.getName(), adjcent);
	  }
	  
	  public String getName(){
	    return name;
	  }

	  public Map<String, Node> getAdjcents(){
	    return adjcents;
	  }

	  public void setVisited(boolean visited){
	    this.visited = visited;
	  }

	  public boolean isVisited(){
	    return visited;
	  }
	}
}
