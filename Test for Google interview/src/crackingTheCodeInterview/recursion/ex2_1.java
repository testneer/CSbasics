package crackingTheCodeInterview.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ex2_1 {

	public static void main(String[] args) {
		Node head = new Node(2);
		head.addNodeToHead(4).addNodeToHead(6).addNodeToHead(4).addNodeToHead(6).addNodeToHead(1);
		Node.printLL(head);
		removeDups2(head);
		Node.printLL(head);
		
		Node n = new Node(3);
		Node n2 = new Node(3);
		System.out.println(n.hashCode() == n2.hashCode());
		Set<Node> mySet = new HashSet<>();
		mySet.add(n2);
		mySet.add(n);
		System.out.println(Arrays.toString(mySet.toArray()));
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
