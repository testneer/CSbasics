package crackingTheCodeInterview.recursion;

import java.util.ArrayList;
import java.util.Arrays;

import crackingTheCodeInterview.recursion.ex4_2.Node;

public class ex4_4 {

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,12,13,14,34,23,43,44,45,46,66,67,68,69,70};
		Node<Integer> root = ex4_2.convertToBST(arr);
//		root.left.left.left = null;
//		root.left.right = null;
		BTreePrinter.printNode(root);
		System.out.println(isBalanced(root));
		System.out.println("height " + ex4_0.getBiTreeHeight(root));
	}
	
	public static boolean isBalanced(Node root){
		boolean allSubRouteBalanced = true; 
		if(root == null){
			return true;
		}
		
		if(isbalanceBroken(root)){
			return false;
		}
		
		
		return isBalanced(root.left) && isBalanced(root.right);
		
	}

	private static boolean isbalanceBroken(Node root) {
		if(root.left == null && root.right != null){
			if(root.right.left != null || root.right.right != null){
				return true;
			}
		}
		if(root.left != null && root.right == null){
			if(root.left.left != null || root.left.right != null){
				return true;
			}
		}
		return false;
	}

}
