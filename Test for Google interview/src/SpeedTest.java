import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SpeedTest {

	public static boolean useList(String[] arr, String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}
	public static boolean useSet(String[] arr, String targetValue) {
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		return set.contains(targetValue);
	}
	public static boolean useLoop(String[] arr, String targetValue) {
		for(String s: arr){
			if(s.equals(targetValue))
				return true;
		}
		return false;
	}
	
	public static boolean useArraysBinarySearch(String[] arr, String targetValue) {	
		int a =  Arrays.binarySearch(arr, targetValue);
		if(a > 0)
			return true;
		else
			return false;
	}
	
	public static boolean useMap(String[] arr, String targetValue) {	
		Map<String, String> map = new HashMap<>();
		for(String s: arr){
			map.put(s, "T");
		}
		return map.get(targetValue) == "T";
		
	}
	static protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZY";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        int stringLength = rnd.nextInt(12)+1; 
        while (salt.length() < stringLength) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public static void main(String[] args) {
		String[] arr = new String[1000];
		 
		for(int i=0; i< 1000; i++){
			arr[i] = getSaltString();
		}
		System.out.println(Arrays.toString(arr));
	 
//		//use list
//		long startTime = System.nanoTime();
//		for (int i = 0; i < 100000; i++) {
//			useList(arr, "A");
//		}
//		long endTime = System.nanoTime();
//		long duration = endTime - startTime;
//		System.out.println("useList:  " + duration / 1000000);
//	 
//		//use set
//		startTime = System.nanoTime();
//		for (int i = 0; i < 100000; i++) {
//			useSet(arr, "A");
//		}
//		endTime = System.nanoTime();
//		duration = endTime - startTime;
//		System.out.println("useSet:  " + duration / 1000000);
//	 
//		//use loop
//		startTime = System.nanoTime();
//		for (int i = 0; i < 100000; i++) {
//			useLoop(arr, "A");
//		}
//		endTime = System.nanoTime();
//		duration = endTime - startTime;
//		System.out.println("useLoop:  " + duration / 1000000);
//	 
//		//use Arrays.binarySearch()
//		startTime = System.nanoTime();
//		for (int i = 0; i < 100000; i++) {
//			useArraysBinarySearch(arr, "A");
//		}
//		endTime = System.nanoTime();
//		duration = endTime - startTime;
//		System.out.println("useArrayBinary:  " + duration / 1000000);
//		
//		//use Arrays.binarySearch()
//		startTime = System.nanoTime();
//		for (int i = 0; i < 100000; i++) {
//			useMap(arr, "A");
//		}
//		endTime = System.nanoTime();
//		duration = endTime - startTime;
//		System.out.println("useMap:  " + duration / 1000000);
	}
}
