package crackingTheCodeInterview.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ex2_7 {

	public static void main(String[] args) {
		HashMap<Node,Node> set = new HashMap<>();
		Node node2 = new Node(2);
		Node node2a = new Node(2);
		
//		System.out.println(node2.equals(node2a));
//		System.out.println(node2 == node2a);
		
		System.out.println(set.put(node2, node2));
		System.out.println(set.put(node2a, node2a));
		System.out.println(Integer.toBinaryString(4));
	}
	
	public static class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
		
		
		public boolean equals(Object obj){
			if(obj == null){
				return false;
			}
			if (obj == this){
				return true;
			}
			if(obj instanceof Node){
				if (((Node)obj).data == this.data){
					return true;
				}
			}
			return false;
		}
		
		//@Override
		public int hashCode(){
			int prime = 31;
			int result = 1;
			result = result*prime+data;
			return result;
		}
	}
	

}
