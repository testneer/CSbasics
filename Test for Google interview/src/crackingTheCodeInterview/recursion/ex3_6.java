package crackingTheCodeInterview.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


public class ex3_6 {

	public static void main(String[] args) throws InterruptedException {
		AnimalQueue q = new AnimalQueue();
		Animal dog1 = new Animal.Dog();
		Thread.sleep(1);
		Animal cat2 = new Animal.Cat();
		Thread.sleep(1);
		Animal dog3 = new Animal.Dog();
		Thread.sleep(1);
		Animal dog4 = new Animal.Dog();
		Thread.sleep(1);
		q.enqueue(dog1);
		Thread.sleep(1);
		q.enqueue(cat2);
		Thread.sleep(1);
		q.enqueue(dog3);
		Thread.sleep(1);
		q.enqueue(dog4);
		Thread.sleep(1);
		System.out.println(q);
		q.dequeueAny();
		System.out.println(q);
		q.dequeueCat();
		System.out.println(q);
//		q.dequeueCat();
		System.out.println(q);
		
	}
	
	public static class AnimalQueue{
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(Arrays.toString(dogs.toArray())).append("\n").append(Arrays.toString(cats.toArray()));
			return sb.toString();
			
		}
		private Queue<Animal> dogs = new LinkedList<>();
		private Queue<Animal> cats = new LinkedList<>();
		
		public void enqueue(Animal animal){
			if(animal instanceof Animal.Dog){
				dogs.add(animal);
			}
			else if(animal instanceof Animal.Cat){
				cats.add(animal);
			}
		}
		
		public Animal dequeueDog(){
			return dogs.remove();
		}
		
		public Animal dequeueCat(){
			return cats.remove();
		}
		
		public Animal dequeueAny() throws NoSuchElementException{
			Animal dog = dogs.peek();
			Animal cat = cats.peek();
			
			if(dog == null && cat == null){
				throw new NoSuchElementException();
			}
			if(dog == null){
				return cats.remove();
			}
			else if(cat == null){
				return dogs.remove();
			}
			else{
				return dog.getTimeAdded() < cat.getTimeAdded()?dogs.remove():cats.remove();
			}
		}
	}

}

