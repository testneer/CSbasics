package crackingTheCodeInterview.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ex2_1 {

	public static void main(String[] args) {
		Node head = new Node(2);
		head.addNodeToHead(4).addNodeToHead(6).addNodeToHead(4).addNodeToHead(6).addNodeToHead(1);
		printLL(head);
		removeDups2(head);
		printLL(head);
		
		Node n = new Node(3);
		Node n2 = new Node(3);
		System.out.println(n.hashCode() == n2.hashCode());
		Set<Node> mySet = new HashSet<>();
		mySet.add(n2);
		mySet.add(n);
		System.out.println(Arrays.toString(mySet.toArray()));
	}
	
	public static void printLL(Node node){
		StringBuilder sb = new StringBuilder();
		sb.append(node.toString());
		while(node.next != null){
			sb.append(" -> ").append(node.next.toString());
			node = node.next;
		}
		System.out.println(sb.toString());

	}
	
	public static class Node {
		Node next;
		int data;
		
		public Node(int data){
			this.data = data;
		}
		
		public Node addNodeToHead(int data){
			Node node = new Node(data);
			this.next = node;
			return node;
		}
		
		public String toString(){
			return ""+data;
		}

//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + data;
//			return result;
//		}

//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Node other = (Node) obj;
//			if (data != other.data)
//				return false;
//			return true;
//		}
		
		public boolean equals(Object obj) {
			if(obj == null){
				return false;
			}
			if(obj == this){
				return true;
			}
			if(obj instanceof Node && this.data == ((Node)obj).data){
				return true;
			}
			return false; 
		}
		
		public int hashCode() {
			int prime = 31;
			int result = 1;
			result = prime * result + data;
			return result;
		}
		
		
	}
	
	
	public static void removeDups2(Node head){
		Node n = head;
		Node runner = head;
		
		while(n.next != null){
			while(runner.next != null){
				if(n.equals(runner.next)){
					runner.next = runner.next.next;
				}
				else{
					runner = runner.next;
				}
			}
			n = n.next;
			runner = n;
		}
	}
	
	
	public static void removeDups1(Node head){
		Node n = head;
		Set<Node> elements = new HashSet<>();
		elements.add(head);
		
		while(n.next != null){
			if(elements.contains(n.next)){
				n.next = n.next.next;
			}
			else{
				n = n.next;
				elements.add(n);
			}
		}
	}
}
