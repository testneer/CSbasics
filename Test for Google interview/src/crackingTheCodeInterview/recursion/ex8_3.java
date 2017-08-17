package crackingTheCodeInterview.recursion;

public class ex8_3 {

	public static void main(String[] args) {
	
//		int[] arr = {-10,-5,2,2,2,3,4,76,9,12,13};
//		int[] arr = {1,1,1,2,5,6,9};
		int[] arr = {-1,0,1,5,5,6,6,6,6};
	  System.out.println(hasMagicNumberIter(arr));
	  System.out.println(hasMagicNumberRec(arr));
	}
	
	
	static boolean hasMagicNumberIter(int[] input){
		  if(input == null){
		    throw new IllegalArgumentException("input is null");
		  }  
		  
		  int remindingLength = input.length /2; //2
		  int index = remindingLength; //2
		 
		  while(true){
		    int currentValue = input[index]; //3
		    if(currentValue == index){
		      return true;
		    }
		    else if (currentValue < index){
		      index = index + remindingLength;
		    }
		    else if(currentValue > index){
		      index = index - remindingLength;
		    }
		    if(remindingLength == 0){
		      return false;
		    }
		    remindingLength = remindingLength/2;
		  }
		}
	
	static boolean hasMagicNumberRec(int[] input){
		  if(input == null){
		    throw new IllegalArgumentException("input is null");
		  }
		  return hasMagicNumberRecImpl(input, input.length, input.length/2); //{1}
		}
		 
		static boolean hasMagicNumberRecImpl(int[] input, int remainingLength, int index){ //{-1,-2,3}
		  boolean result = false;
		  // base case
		  if(remainingLength == 0){
		    return false;
		  }
		 
		  int currentValue = input[index]; //2
		  if(currentValue == index){
		    return true;
		  }
		  else if (currentValue < index){
			  result = hasMagicNumberRecImpl(input, remainingLength/2, index+remainingLength/2);
		  }
		  else if(currentValue > index){
			  if(currentValue < input.length){
			      if(input[currentValue] == currentValue){
			        return true;
			      }
			    }
			  result =  hasMagicNumberRecImpl(input, remainingLength/2, index-remainingLength/2); //input, 1 -1
		  }
		  return result;
		}  
}
