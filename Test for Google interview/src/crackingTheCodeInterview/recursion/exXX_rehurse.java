package crackingTheCodeInterview.recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import crackingTheCodeInterview.recursion.ex4_0.Graph;
import crackingTheCodeInterview.recursion.ex4_0.GraphNode;
import crackingTheCodeInterview.recursion.ex4_0.VisitStatus;
import crackingTheCodeInterview.ood.deckOfCards.TsetOOD;
import crackingTheCodeInterview.recursion.GraphNode2;
import crackingTheCodeInterview.recursion.ex4_2.Node;

public class exXX_rehurse {

	public static void main(String[] args) throws FileNotFoundException {
		//implement a tree traversal
//		treeEx();
		//bfs
//		graphsEx();
		//scanner exercise + File system ex
//		scannerEx( "/Users/orenegauthier/Desktop/book.txt");
//		scannerExChar( "/Users/orenegauthier/Desktop/book.txt");
		//Graphs excersices
		
		//MergeSort
		
		//QuickSort
		int[] arr = {1,3,7,3,9,8,3,6,90,4};
//		quickSort(arr);
//		System.out.println("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
//		System.out.println(Arrays.toString(arr));
//		//Binary search
//		System.out.println(biSearch(arr, 90));
		//change problem
		int[] denom = new int[]{1, 2, 3};
		int amount = 4;
		System.out.println(findChange(denom,amount));
		System.out.println(findChange2(denom,amount));
		System.out.println(changePossibilitiesTopDown(amount,denom));
//		Set<char[]> results = new HashSet<>();
//		results.add(new char[]{'1','1'});
//		results.add(new char[]{'1','1'});
//		System.out.println(Arrays.deepToString(results.toArray()));
//		List<Integer> list = new ArrayList<>();
//		list.add(4);
//		List<Integer> list2 = new ArrayList<>(list);
//		System.out.println(Arrays.toString(list.toArray()));
	}

	  public static int changePossibilitiesTopDown(int amount, int[] denominations) {
		    return changePossibilitiesTopDown(amount, denominations, 0);
		}

		private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex) {

		    // base cases:
		    // we hit the amount spot on. yes!
		    if (amountLeft == 0) {
		        return 1;
		    }

		    // we overshot the amount left (used too many coins)
		    if (amountLeft < 0) {
		        return 0;
		    }

		    // we're out of denominations
		    if (currentIndex == denominations.length) {
		        return 0;
		    }

		    System.out.println(String.format("checking ways to make %d with %s", amountLeft, Arrays.toString(Arrays.copyOfRange(denominations, currentIndex, denominations.length))));

		    // choose a current coin
		    int currentCoin = denominations[currentIndex];

		    // see how many possibilities we can get
		    // for each number of times to use currentCoin
		    int numPossibilities = 0;
		    while (amountLeft >= 0) {
		        numPossibilities += changePossibilitiesTopDown(amountLeft, denominations,
		            currentIndex + 1);
		        amountLeft -= currentCoin;
		    }

		    return numPossibilities;
		}
		
	static int findChange2(int[] denom, int amount){
		int ret = findChange2(denom,amount, 0, new HashMap<String,Integer>());
		return ret;
	}
	
	static int findChange2(int[] denom, int amount, int currentSum, Map<String,Integer> memo){
		int totalCount=0;
		//Base cases
		if(currentSum == amount){
			return 1;
		}
		if(currentSum > amount){
			return 0;
		}
		System.out.println("currentSum: " + currentSum);
		Integer memSum = memo.get(currentSum+"");
		if(memSum != null){
			return memSum;
		}
		
		for(int d : denom){
			totalCount += findChange2(denom, amount, currentSum+d, memo);
			memo.put(currentSum+"", totalCount);
		}
		System.err.println(Arrays.deepToString(memo.entrySet().toArray()));
		return totalCount;
	}
	
	static int findChange(int[] denom, int amount){
		Set<String> results = new HashSet<>();
		int ret = findChange(denom,amount, 0, "", results);
		System.out.println(Arrays.deepToString(results.toArray()));
		return ret;
	}
	
	static int findChange(int[] denom, int amount, int currentSum, String word, Set<String> results){
		
		//Base cases
		if(currentSum == amount){
			char[] denomSequence = word.toCharArray();
			Arrays.sort(denomSequence);
			
			StringBuilder sb = new StringBuilder();
			for(char c : denomSequence){
				sb.append(c);
			}
			results.add(sb.toString());
			return 0;
		}
		if(currentSum > amount){
			return 0;
		}
		
		for(int d : denom){
			findChange(denom, amount, currentSum+d, word+d, results);
		}
		return results.size();
	}
	
	private static int biSearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length-1;
		while(low <= high){
			System.out.println("(low:"+low+" high:"+high+")");
			int mid = (low+high)/2;
			if(arr[mid] < key){ //search right
				low = mid+1;
			}
			else if(arr[mid] > key){
				high = mid -1;
			}else{
				return mid;
			}
		}
		return -1;
	}

	private static void quickSort(int[] arr){
		// Kaki done ):
		if(arr == null || arr.length <=1){
			return;
		}
		quickSort(arr, 0, arr.length-1);
	}
	private static void quickSort(int[] arr, int left, int right) {
		if(left>=right){
			return;
		}
		int index = partition(arr, left, right);
		quickSort(arr, left, index-1);
		quickSort(arr, index, right);
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left+right)/2];
		
		while(left<=right){
			while(arr[left] < pivot){
				left++;
			}
			while(arr[right] > pivot){
				right--;
			}
			
			if(left<=right){
				if(right != left){
					int temp = arr[left];
					arr[left] = arr[right];
					arr[right] = temp;
				}
//				arr[left] = arr[left]^arr[right]; 
//				arr[right] = arr[left]^arr[right]; 
//				arr[left] = arr[left]^arr[right];
				left++;
				right--;
			}
		}
		return left;
	}

	private void mergeSort(int[] arr){
		//Done well :)
	}

	private static int[][] scannerExChar(String path) throws FileNotFoundException{
		//count chars (a-z, A-Z) from array.
		if(path == null || path.length() == 0){
			throw new IllegalArgumentException();
		}
		Scanner scanner = new Scanner(new FileInputStream(path));
		int[][] frequencies = new int[52][2];
		
		while(scanner.hasNext()){
			String s = scanner.next();
			s = s.replaceAll("[^A-Za-z]", "").trim();
			if(!s.isEmpty()){
				addCharsToCount(s, frequencies);
			}
		}
		System.out.println(Arrays.deepToString(frequencies));
		for(int i = 0; i < frequencies.length; i++){
			if(frequencies[i][0] != 0){
				char c = (char)frequencies[i][0];
				System.out.println(c+":"+ frequencies[i][1]);
			}
		}
		scanner.close();
		return frequencies;
	}
	
	private static void addCharsToCount(String s, int[][] frequencies) {
		int upperCaseIndexOffset = 26;
		int charLocation= -1;
		for (int i = 0; i< s.length(); i++){
			char c = s.charAt(i);
			if(c >= 'a' && c <= 'z'){
				charLocation = c -'a';
			}
			else if(c >= 'A' && c <= 'Z'){
				charLocation = c -'A' + upperCaseIndexOffset;
			}
			if(frequencies[charLocation][0] == 0){
				frequencies[charLocation][0] = c;
			}
			frequencies[charLocation][1]++;
		}
	}
	
	private static Map<String, Integer> scannerEx(String path) throws FileNotFoundException{
		//scan words from file
		if(path == null || path.length() == 0){
			throw new IllegalArgumentException();
		}
		Scanner scanner = new Scanner(new FileInputStream(path));
		Map<String, Integer> frequencies = new HashMap<>();
		
		while(scanner.hasNext()){
			String s = scanner.next();
			System.out.println(s);
			s = s.toLowerCase().replaceAll("[^A-Za-z]", "").trim();
			if(!s.isEmpty()){
				addStringToCount(s, frequencies);
			}
		}
		System.out.println(Arrays.toString(frequencies.entrySet().toArray()));
		scanner.close();
		return frequencies;
	}

	private static void addStringToCount(String s, Map<String, Integer> frequencies) {
		Integer i = frequencies.get(s);
		if(i == null){
			frequencies.put(s,1);
		}
		else{
			frequencies.put(s,i.intValue()+1);
		}
		
	}

	private static void graphsEx() {
		GraphNode2 node0 = new GraphNode2(0);
		GraphNode2 node1 = new GraphNode2(1);
		GraphNode2 node2 = new GraphNode2(2);
		GraphNode2 node3 = new GraphNode2(3);
		GraphNode2 node4 = new GraphNode2(4);
		GraphNode2 node5 = new GraphNode2(5);
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
		bfs(node0);
		g.clearVisited();
		System.out.println();
		dfs(node0);
	}

	private static void dfs(GraphNode2 root) {
		if(root == null){
			return;
		}
		
		root.vs=VisitStatus.VISITED;
		System.out.print(root.value + "-> ");
		for(GraphNode node: root.adjcents){
			if(node != null && node.vs != VisitStatus.VISITED){
				dfs(((GraphNode2)node));
			}
		}
	}

	private static void bfs(GraphNode2 root) {
		Queue<GraphNode2> q = new LinkedList<>();
		root.vs = VisitStatus.VISITING;
		q.add(root);
		while(!q.isEmpty()){
			GraphNode2 next = q.remove();
			if(next.vs != VisitStatus.VISITED){
				next.vs = VisitStatus.VISITED;
				for(GraphNode node : next.adjcents){
					if( node != null && ((GraphNode2)node).vs != VisitStatus.VISITED){
						node.vs = VisitStatus.VISITING;
						q.add((GraphNode2) node);
					}
				}
				System.out.print(next.value + "-> ");
			}
		}
	}

	private static void treeEx() {
		int[] arr = {2,3,4,5,6,12,13,14,34,23,70};
		Node<Integer> root = ex4_2.convertToBST(arr);
		BTreePrinter.printNode(root);
		
		//inorder traversal
//		printOrder(root);
//		printLeftToRight(root);
		printLayers(root);
	}

	private static void printLayers(Node<Integer> root) {
		Queue<Node<Integer>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node<Integer> node = q.remove();
			System.out.println(node.data);
			if(node.left!=null){
				q.add(node.left);
			}
			if(node.right != null){
				q.add(node.right);
			}
		}
	}
	
	private static void printLeftToRight(Node<Integer> root) {
		if(root == null){
			return;
		}
		
		System.out.println(root.data);
		printLeftToRight(root.left);
		printLeftToRight(root.right);
	}
	
	private static void printOrder(Node<Integer> root) {
		if(root == null){
			return;
		}
		
		printOrder(root.left);
		System.out.println(root.data);
		printOrder(root.right);
	}

}
