package crackingTheCodeInterview.recursion;

public class ex2_2 {
	
	
	public static void main(String[] args) {
		Node head = Node.getList();
		Node.printLL(head);
		System.out.println(getKthToEnd(head, 5));
		
	}

	private static Node getKthToEnd(Node head, int kth) {
		if(head == null || kth<0){
			return null;
		}
		
		int counter = 1;
		Node runner = head;
		while(runner.next != null){
			runner = runner.next;
			counter++;
		}
		
		if(kth >= counter){
			return null;
		}
		
		runner = head;
		int target = counter - kth;
		for(int i = 1; i < target; i++){
			runner = runner.next;
		}
		return runner;
		
		
	}

}
