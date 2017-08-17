package crackingTheCodeInterview.recursion;

import java.util.*;

public class ex16_10 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("p1", 15, 17));
		list.add(new Person("p2", 17, 17));
		list.add(new Person("p3", 9, 20));
		list.add(new Person("p4", 1, 14));
		list.add(new Person("p5", 6, 11));
		list.add(new Person("p6", 6, 9));
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println("---" + getMaxPopulationInAYear(list));
		
		/////////////////////////////////////////////////////testShit
		list.sort(new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p1.dob-p2.dob;
			}
		});
		
		List<Person> listByDod = new ArrayList<>(list);
		listByDod.sort(new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p1.dod - p2.dod;
			}
		});
		
		Person[] arr = {new Person("p6", 6, 9), new Person("p2", 5, 10)};
		Arrays.sort(arr,(p1,p2)->p1.dob-p2.dob);
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, (p1,p2)->p1.dod-p2.dod);
		System.out.println(Arrays.toString(arr));
		listByDod.forEach((Person)->System.out.println("oren"));;
	}
	
	public static int getMaxPopulationInAYear(List<Person> list){
		if(list == null || list.size() == 0){
			throw new IllegalArgumentException();
		}
		List<Person> births = list;
		List<Person> deaths = new ArrayList<>(list);
		births.sort((p1,p2)->p1.dob - p2.dob);
		deaths.sort((p1, p2) -> p1.dod - p2.dod);
		
		int deathIndex = 0;
		int birthIndex = 0;
		int maxPop = 0;
		int pop = 0;
		
		while(birthIndex < births.size()){
			if(births.get(birthIndex).dob <= deaths.get(deathIndex).dod){
				pop++;
				
				birthIndex++;
			}
			else{
				deathIndex++;
				pop--;
			}
			maxPop = Math.max(maxPop, pop);
		}
		return maxPop;
	}
	
	
	
	public static class Person {
		int dob;
		int dod;
		String name;
		public Person(String name, int dob, int dod){
			this.dob = dob;
			this.dod = dod;
			this.name = name;
		}
		protected int getdod(){
			return dod;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "<"+name + " dob:" + dob + " dod:"+dod +">"; 
		}
	}

}
