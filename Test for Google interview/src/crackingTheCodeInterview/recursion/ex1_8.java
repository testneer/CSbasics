package crackingTheCodeInterview.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ex1_8 {

	public static void main(String[] args) {
		int[][] input = {
				{1,2,3,0},
				{1,2,3,4},
				{1,2,3,4},
				{1,0,3,4},
				{1,0,3,4},
				{1,0,3,4},
		};
		for(int i = 0; i < input.length; i++){
			System.out.println(Arrays.toString(input[i]));
		}
		System.out.println();
		setZeros(input);
		for(int i = 0; i < input.length; i++){
			System.out.println(Arrays.toString(input[i]));
		}
	}
	
	static void setZeros(int[][] matrix){
		Set<Integer> zeroRows = new HashSet<>();
		Set<Integer> zeroCol = new HashSet<>();
		
		for(int row = 0; row < matrix.length ;row++){
//			if(!zeroRows.contains(row)){
				for(int col = 0; col < matrix[0].length; col++){
//					if(!zeroCol.contains(col)){
						if(matrix[row][col] == 0){
							zeroRows.add(row);
							zeroCol.add(col);
						}
//					}
				}
//			}
		}
		for(Integer row : zeroRows){
			for(int i = 0; i < matrix[0].length; i++){
				matrix[row.intValue()][i] = 0;
			}
		}
		for(Integer col : zeroCol){
			for(int i = 0; i < matrix.length; i++){
				matrix[i][col.intValue()] = 0;
			}
		}
	}

}
