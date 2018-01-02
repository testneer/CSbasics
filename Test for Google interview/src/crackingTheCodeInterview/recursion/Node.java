package crackingTheCodeInterview.recursion;

public  class Node {
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

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + data;
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Node other = (Node) obj;
//		if (data != other.data)
//			return false;
//		return true;
//	}
	
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
	
	public static void printLL(Node node){
		StringBuilder sb = new StringBuilder();
		sb.append(node.toString());
		while(node.next != null){
			sb.append(" -> ").append(node.next.toString());
			node = node.next;
		}
		System.out.println(sb.toString());

	}
	
	public static Node getList(){
		Node head = new Node(2);
		head.addNodeToHead(4).addNodeToHead(6).addNodeToHead(4).addNodeToHead(6).addNodeToHead(1);
		return head;
	}
	
	
}
