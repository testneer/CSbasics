package crackingTheCodeInterview.recursion;

import java.util.EmptyStackException;


public class ex3_0 {

	public static void main(String[] args) {
		OrenStack<Object> os = new OrenStack<>();
		os.push("oren");
		os.push("oren2");
		os.push("oren3");
		System.out.println(os.pop());
		os.remove();
		System.out.println(os.pop());	
		Exception myException = new MyException();
		Exception myException1 = new MyException("kak");
	}
	
	public static class MyException extends RuntimeException{

		public MyException() {
			super();
		}
		
		public MyException(String string) {
			super(string);
		}
		
	}
	
	public static class OrenStack<T>{
		StackNode<T> top = null;
		private int size = 0;
		//push
		public void push(T element){
			StackNode<T> newItem = new StackNode<T>(element);
			if(top != null){
				newItem.below = top;
			}
			top = newItem;
			size++;
		}
		
		public T pop(){
			if(isEmpty()){
				throw new EmptyStackException();
			}
			StackNode<T> node = top;
			if(size == 1){
				top = null;
			}
			else{
				top = node.below;
			}
			size--;
			return node.data;
		}
		
		public boolean isEmpty(){
			return size==0;
		}
		
		
	//	peak
		public T peak(){
			if(isEmpty()){
				throw new EmptyStackException();
			}
			else{
				return top.data;
			}
		}
		
		//remove
		public void remove(){
			if(isEmpty()){
				throw new MyException();
			}
			StackNode<T> node = top;
			if(size == 1){
				top = null;
			}
			else{
				top = node.below;
			}
			size--;
		}
	}
	
	private static class StackNode<T>{
		T data;
		StackNode<T> below;
		
		public StackNode (T data){
			this.data = data;
		}
	}

}
