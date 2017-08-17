package crackingTheCodeInterview.recursion;

import java.util.Arrays;
import java.util.EmptyStackException;

import crackingTheCodeInterview.recursion.ex3_1.StackOfThree2.StackId;

public class ex3_1 {

	public static void main(String[] args) {
		StackOfThree s3 = new StackOfThree(6);
		s3.add(StackOfThree.StackNum.ONE, 2);
		s3.add(StackOfThree.StackNum.TWO, 3);
		s3.add(StackOfThree.StackNum.TWO, 4);
		
		try {
			StackOfThree2 s = new StackOfThree2(10);
			System.out.println(s);
			s.push(StackId.ONE, 1);
			System.out.println(s);
			s.push(StackId.TWO, 2);
			System.out.println(s);
			System.out.println(s.pop(StackId.TWO));
			System.out.println(s);
			
			System.out.println("------------------");
			
			StackOfThree3 s4 = new StackOfThree3(3);
			System.out.println(s4);
			s4.push(0, 1);
			System.out.println(s4);
			s4.push(1, 2);
			s4.push(1, 2);
			s4.push(1, 2);
			s4.push(1, 2);
			System.out.println(s4);
		System.out.println(s4.pop(1));
			System.out.println(s4);
		} catch (StackFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static class StackOfThree3{
		private final int stackCount = 3;
		private int stackCapacity;
		private int[] sizes;
		private int[] stacks;
		
		public StackOfThree3(int stackSize){
			stacks = new int[stackSize*stackCount];
			sizes = new int[stackCount];
			stackCapacity = stackSize;
		}
		
		private int getTopIndex(int stackId){
			int offset = stackId*stackCount;
			return offset+sizes[stackId];
		}
		
		public void push(int id, int data) throws StackFullException{
			if(sizes[id] == stackCapacity){
				throw new StackFullException();
			}
			stacks[getTopIndex(id)] = data;
			sizes[id]++;
		}
		
		public boolean isEmpty(int id){
			return sizes[id] == 0;
		}

		public int peek(int id) throws EmptyStackException{
			if (isEmpty(id)){
				throw new EmptyStackException();
			}
			return stacks[getTopIndex(id)];
		}
		
		public int pop(int id) throws EmptyStackException{
			if (isEmpty(id)){
				throw new EmptyStackException();
			}
			sizes[id]--;
			int topIndex = getTopIndex(id);
			int ret = stacks[topIndex];
			stacks[topIndex] = 0;
			return ret;
		}
		
		public String toString(){
			return Arrays.toString(stacks);
		}
	}
	
	public static class StackOfThree2{
		private int[] starts = new int[3];
		private int[] tops = {-1, -1, -1};
		private int[] ends = new int[3];
		private int[] stacks;
		
		public enum StackId{
			ONE,
			TWO,
			THREE
		}
		
		public StackOfThree2(int size){
			stacks = new int[size];
			
			starts[StackId.ONE.ordinal()] = 0;
			starts[StackId.TWO.ordinal()] = size/3;
			starts[StackId.THREE.ordinal()] = size/3*2;
			
			ends[StackId.ONE.ordinal()] = starts[StackId.TWO.ordinal()] -1;
			ends[StackId.TWO.ordinal()] = starts[StackId.THREE.ordinal()] -1;
			ends[StackId.THREE.ordinal()] = size -1;
		}
		
		public void push(StackId id, int data) throws StackFullException{
			if(tops[id.ordinal()] == ends[id.ordinal()]){
				throw new StackFullException();
			}
			if(tops[id.ordinal()] == -1){
				tops[id.ordinal()] = starts[id.ordinal()];
			}
			else{
				tops[id.ordinal()] = tops[id.ordinal()] +1;
			}
			stacks[tops[id.ordinal()]] = data;
		}
		
		public boolean isEmpty(StackId id){
			return tops[id.ordinal()] == -1;
		}

		public int peek(StackId id) throws EmptyStackException{
			if (isEmpty(id)){
				throw new EmptyStackException();
			}
			return stacks[tops[id.ordinal()]];
		}
		
		public int pop(StackId id) throws EmptyStackException{
			if (isEmpty(id)){
				throw new EmptyStackException();
			}
			int ret = stacks[tops[id.ordinal()]];
			stacks[tops[id.ordinal()]] = 0;
			tops[id.ordinal()] = tops[id.ordinal()] -1;
			if(tops[id.ordinal()] == starts[id.ordinal()]){
				tops[id.ordinal()] = -1;
			}
			return ret;
		}
		
		public String toString(){
			return Arrays.toString(stacks);
		}
	}
	
	
	
	
	public static class StackOfThree{
		
		private static class StackItem{
			Object data;
			int next = -1; //set to -1 of there are no links to the next element;
			
			public StackItem(Object data){
				this.data = data;
			}
		}
		
		public static enum StackNum{
			ONE,
			TWO,
			THREE
		}
		
		private int totalSize;
		private StackItem[] stacks;
		private int top1 = -1;
		private int top2 = -1;
		private int top3 = -1;
		private int nextFree = 0; //-1 to denote no more free space
		
		public StackOfThree(int size){
			this.totalSize = size;
			stacks = new StackItem[size];
		}
		
		public void add(StackNum num, Object data){
			if(nextFree == -1) {
				throw new RuntimeException("Stack is full");
			}
			StackItem item = new StackItem(data);
			int currentTop = getCurrentTop(num);
			if(currentTop == -1){
				item.next = currentTop;
			}
			stacks[nextFree] = item;
			setNewTop(num, nextFree);
			nextFree = calcNextFree();
		}

		private int calcNextFree() {
			for(int i = nextFree; i < totalSize; i++){
				if(stacks[i] == null){
					return i;
				}
			}
			return -1;
		}

		private void setNewTop(StackNum num, int newTop) {
			switch (num){
			case ONE:
				top1 = newTop;
			case TWO:
				top2 = newTop;
			case THREE:
				top3 = newTop;
			}
		}

		private int getCurrentTop(StackNum num) {
			switch (num){
			case ONE:
				return top1;
			case TWO:
				return top2;
			case THREE:
				return top3;
			}
			throw new RuntimeException("internal error");
		}
	}

}
