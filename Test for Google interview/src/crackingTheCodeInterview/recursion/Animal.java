package crackingTheCodeInterview.recursion;


public class Animal {
	private long timeAdded;
	
	public Animal(){
		this.timeAdded = System.currentTimeMillis();
	}
	public long getTimeAdded(){
		return timeAdded;
	}
	
	public static class Dog extends Animal{
		public String toString(){
			return this.getClass().getSimpleName() + ":" + this.getTimeAdded();
		}
	}
	
	public static class Cat extends Animal{
		public String toString(){
			return this.getClass().getSimpleName() + ":" + this.getTimeAdded();
		}
	}
}
