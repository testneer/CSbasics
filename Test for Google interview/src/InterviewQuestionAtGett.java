
public class InterviewQuestionAtGett {

	public static void main(String[] args){
		O1DS ds = new O1DS();
		ds.init(5);
		ds.set(2, 2);
		System.out.println(ds.get(2));
		ds.deleteAll();
		System.out.println(ds.get(2));
		
	}

	static class O1DS{
		Node[] arr;
		
		//init
		public void init(int size){
			arr = new Node[size];
		}
		
		//put
		public void set(int index, int value){
			if(arr[index] == null){
				arr[index] = new Node(value);
			}
			else{
				arr[index].value = value;
			}
			
		}
		
		//get @ index
		public int get(int index){
			if(arr[index] == null){
				return 0;
			}
			return arr[index].value;
			
		}
		
		//delete all
		public void deleteAll(){
			arr = new Node[arr.length];
		}
	}
	
	
	
	
	static class Node{
		int value;
		public Node(int v){
			this.value = v;
		}
	}
}
