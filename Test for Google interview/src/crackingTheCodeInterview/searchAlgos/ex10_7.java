package crackingTheCodeInterview.searchAlgos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ex10_7 {

	public static void main(String[] args) {
		String path = "/Users/orenegauthier/Desktop/ints.txt";
		try {
			System.out.println(findMissingInt(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int findMissingInt(String path) throws FileNotFoundException{
		byte[] arr = new byte[Byte.MAX_VALUE/8+1];
		FileReader fr;
		Scanner scanner;;
		
		fr = new FileReader(path);
		scanner = new Scanner(fr);
		byte num;
		while(scanner.hasNextByte()){
			num = scanner.nextByte();
			saveNumber(arr, num);
		}
		scanner.close();
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != -1){
				byte b = getPosition(arr[i]);
				if(b != -1){
					return b + i*8;
				}
				break;
			}
		}
		return -1;
	}

	private static byte getPosition(byte b) {
		for(int i = 0; i<8; i++){
			if(b%2 == 0){
				return (byte) (i +1);
			}
			else{
				b=(byte) (b>>1);
			}
		}
		return -1;
	}

	private static void saveNumber(byte[] arr, byte num) {
		num = (byte) (num - 1);
		int index = num/8;
		int bitNumber = num % 8;
		arr[index] = (byte) (arr[index] | (1 << bitNumber));
	}
}
