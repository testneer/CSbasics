package crackingTheCodeInterview.recursion;

public class ex4_2 {

//	public static class Node{
//		Node left, right;
//		int value;
//		public Node(int value){
//			this.value = value;
//		}
//	}
	
	public static BiNode<Integer> convertToBST(int[] arr){
		return convertToBSTRec(arr, 0, arr.length-1);
	}

	private static BiNode<Integer> convertToBSTRec(int[] arr, int start, int end) {
		//base case
		if(end<start){
			return null;
		}
		int middle = (start+end)/2;
		BiNode<Integer> node = new BiNode<>(arr[middle]);
		node.left = convertToBSTRec(arr, start, middle-1);
		node.right = convertToBSTRec(arr, middle+1, end);
		return node;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,12,13,14};
		BiNode<Integer> root = convertToBST(arr);
		BTreePrinter.printNode(root);
	}

	public static class Node<T extends Comparable<?>> {
	    Node<T> left, right;
	    T data;

	    public Node(T data) {
	        this.data = data;
	    }
	    
	    public String toString(){
	    	return data.toString();
	    }
	}
	
}
