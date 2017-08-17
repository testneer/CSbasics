package crackingTheCodeInterview.recursion;

import java.util.Arrays;
import java.util.LinkedList;

public class ex2_4 {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(10);
		list.addLast(5);
		list.addLast(8);
		list.addLast(5);
		list.addLast(3);
		System.out.println(Arrays.toString(list.toArray()));
		partitionList(list, 12);
		System.out.println(Arrays.toString(list.toArray()));
		
		//TEST
		int a = 375;
		System.out.println(a%10);
		a/=10 ;
		System.out.println(a%10);
		a/=10 ;
		System.out.println(a%10);
		a/=10 ;
		System.out.println(a%10);
	}
	
	public static void partitionList(LinkedList<Integer> list, int party){
		LinkedList<Integer> left = new LinkedList<>();
		LinkedList<Integer> right = new LinkedList<>();
		
		while(!list.isEmpty()){
			Integer data = list.remove();
			if(data.intValue() < party){
				left.addFirst(data);
			}
			else{
				right.add(data);
			}
		}
		list.addAll(left);
		list.addAll(right);
		return;
	}

}
