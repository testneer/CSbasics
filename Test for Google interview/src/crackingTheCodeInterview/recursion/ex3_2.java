package crackingTheCodeInterview.recursion;

import java.util.EmptyStackException;
import java.util.Stack;


public class ex3_2 {

	public static void main(String[] args) {
		MinStack ms = new MinStack();
		System.out.println(ms.toString());
		ms.push(3);
		System.out.println(ms.toString());
		ms.push(4);
		System.out.println(ms.toString());
		ms.push(1);
		System.out.println(ms.toString());
		ms.push(2);
		System.out.println(ms.toString());
		ms.pop();
		System.out.println(ms.toString());
		ms.pop();
		System.out.println(ms.toString());

		
		MinStack2 ms2 = new MinStack2();
		System.out.println(ms2.toString());
		ms2.push(3);
		System.out.println(ms2.toString());
		ms2.push(4);
		System.out.println(ms2.toString());
		ms2.push(1);
		System.out.println(ms2.toString());
		ms2.push(2);
		System.out.println(ms2.toString());
		ms2.pop();
		System.out.println(ms2.toString());
		ms2.pop();
		System.out.println(ms2.toString());
		
	}
	
	public static class MinStack2 extends Stack<MinStackNode>{
		
		public void push(int item) {
			MinStackNode element = new MinStackNode(item);
			if(empty()){
				element.min = item;
			}
			else{
				element.min = Math.min(getmMin(), item);
			}
			super.push(element);
		}
		
		public int getmMin(){
			if(isEmpty()){
				throw new EmptyStackException();
			}
			return peek().min;
		}
		
//		@Override
//		public String toString() {
//			StringBuilder sb = new StringBuilder();
//			MinStackNode current = peek();
//			for(int i = 0; i < size(); i++){
//				sb.append(current.toString()).append(", ");
//				current = current.next;
//			}
//			
//			return sb.toString();
//			 
//		}
	}
	
	public static class MinStackNode{
		int data;
		int min;
		public MinStackNode(int data){
			this.data = data;
		}
		@Override
		public String toString() {
			return "(Data:" + data + " Min:" + min +")";
		}
		
	}
	public static class MinStack{
		private static class StackNode{
			int data;
			int min;
			StackNode next;
			
			public StackNode(int data){
				this.data = data;
			}
			
			@Override
			public String toString() {
				return "(Data:" + data + " Min:" + min +")";
			}
		}
		
		private int size;
		private StackNode top;
		
		public boolean isEmpty(){
			return size == 0;
		}
		
		public void push(int element){
			StackNode node = new StackNode(element);
			if(top == null){
				node.min = element;
			}
			else{
				node.next = top;
				node.min = Math.min(top.min, element);
			}
			top = node;
			size++;
		}
		
		public int size(){
			return size;
		}
		
		public int getMin(){
			if(isEmpty()){
				throw new EmptyStackException();
			}
			return top.min;
		}
		
		public int pop(){
			int ret = peek();
			if(size ==1){
				top = null;
			}
			else{
				top = top.next;
			}
			size --;
			return ret;
		}
		 
		public int peek(){
			if(isEmpty()){
				throw new EmptyStackException();
			}
			return top.data;
	
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			StackNode current = top;
			for(int i = 0; i < size; i++){
				sb.append(current.toString()).append(", ");
				current = current.next;
			}
			
			return sb.toString();
			 
		}
	}
	
	

}












