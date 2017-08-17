package crackingTheCodeInterview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import crackingTheCodeInterview.recursion.ex4_2.Node;


public class ex4_3 {

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,12,13,14,34,23,43,44,45,46,66};
		Node<Integer> root = ex4_2.convertToBST(arr);
		ArrayList result = listOfDepths(root);
		BTreePrinter.printNode(root);
		System.out.println(Arrays.deepToString(result.toArray()));
		
	}
	
	static ArrayList<LinkedList<Node<Integer>>> listOfDepths(Node<Integer> root){
		ArrayList<LinkedList<Node<Integer>>> list = new ArrayList<>();
		LinkedList<Node<Integer>> ll = new LinkedList<>();
		ll.add(root);
		list.add(ll);
		int level = 0;
		while(level < list.size()){
			LinkedList<Node<Integer>> newList = new LinkedList<>();
			for(Node<Integer> node : list.get(list.size()-1)){
				if(node.left != null){
					newList.add(node.left);
				}
				if(node.right != null){
					newList.add(node.right);
				}
			}
			if(newList.size() > 0){
				list.add(newList);
			}
			level++;
		}
		return list;
	}

}
