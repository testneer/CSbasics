package crackingTheCodeInterview.recursion;

import java.util.Arrays;

import javax.swing.text.AbstractDocument.LeafElement;

public class ex1_7 {

	public static void main(String[] args) {
		int[][] simple = {{1,2},{3,4}};
		System.out.println(Arrays.deepToString(simple));
		rotateMatrix(simple);
		rotateMatrix(simple);
		System.out.println(Arrays.deepToString(simple));
		
		System.out.println(Arrays.deepToString(simple));
		rotateMatrix2(simple);
		rotateMatrix2(simple);
		System.out.println(Arrays.deepToString(simple));
		
		
		int[][] simple2 = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.deepToString(simple2));
		rotateMatrix2(simple2);
		System.out.println(Arrays.deepToString(simple2));
		rotateMatrix2(simple2);
		System.out.println(Arrays.deepToString(simple2));
		rotateMatrix2(simple2);
		System.out.println(Arrays.deepToString(simple2));
		rotateMatrix2(simple2);
		System.out.println(Arrays.deepToString(simple2));
		
		int[][] simple3 = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("------------------");
		System.out.println(Arrays.deepToString(simple3));
		rotateMatrix(simple3);
		System.out.println(Arrays.deepToString(simple3));
		rotateMatrix(simple3);
		System.out.println(Arrays.deepToString(simple3));
		rotateMatrix(simple3);
		System.out.println(Arrays.deepToString(simple3));
		rotateMatrix(simple3);
		System.out.println(Arrays.deepToString(simple3));
	}
	
	static void rotateMatrix(int[][] matrix){
		int row = 0;
		int col = 0;
		int lastCurrentIndex = matrix[0].length -1;
		int buff = 0;
		for(int i = lastCurrentIndex; i >= lastCurrentIndex/2; i=i-2){
			for(int j=0; j < i; j++){
				buff = matrix[row+j][col];
				matrix[row+j][col] = matrix[row +i][col + j];
				matrix[row +i][col + j] = matrix[row+i-j][col+i];
				matrix[row+i-j][col+i] = matrix[row][i+col-j];
				matrix[row][i+col-j] = buff;
			}
			row++;
			col++;
		}
	}
	
	static void rotateMatrix2(int[][] matrix){
		int n = matrix[0].length;
		int end = n-1;
		int buffer = 0;
		for(int layer = 0; layer < n/2; layer++){
			end -= layer;
			for(int i = layer; i < end; i++ ){
				buffer = matrix[layer+i][layer]; //buffer = left
				matrix[layer+i][layer] = matrix[end][layer+i]; //left  = bottom  
				matrix[end][layer+i] = matrix[end-i][end];//bottom = right
				matrix[end-i][end] = matrix[layer][end-i];//right = top
				matrix[layer][end-i] = buffer;//top = buffer;
			}
		}
	}
}
