package crackingTheCodeInterview.ood.deckOfCards;

import java.util.*;

public class ex7_1 {

	public static void main(String[] args) {
		Foo foo = new Foo();
		System.out.println(foo);
		foo.shuffle();
		System.out.println(foo);
		
		List<List<ArrayList>> arr = new ArrayList<>();
		
	}
	
	
	public static class Foo<T>{
		List<Integer> list = new ArrayList<>();
		T kak;
		public Foo(){
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			list.add(5);
		}
		
		@Override
		public String toString() {
			return Arrays.toString(list.toArray());
		}
		
		T getT(){
			return kak;
		}
		
		public synchronized void shuffle(){
			if(list == null){
				throw new EmptyShitException();
			}
			Random rnd = new Random();
			List<Integer> shuffled = new ArrayList<>();
			while(!list.isEmpty()){
				shuffled.add(list.remove(rnd.nextInt(list.size())));
			}
			list = shuffled;
		}
	}
}
