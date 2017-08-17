package test.com;

import java.util.Set;

public class TestGenerics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] arr = new Object[1];
		System.out.println(arr[0]);
	}

	
	public class MyClass<S, T> {
		   public        void foo(Set<S> s, Set<T> t){
			   
		   }
		   public <U, V> void bar(Set<U> s, Set<V> t){
			   return;
		   }
		}
	
	public static class tripleQ<T,S>{
		T myItem;
		S myItems;
		public tripleQ(){
			
		}
		
		<G,L> T getstack1q(G kak, L kok){
			return myItem; 
		}
		
	}
}
