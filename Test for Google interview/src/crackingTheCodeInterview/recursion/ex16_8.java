package crackingTheCodeInterview.recursion;

import java.util.*;

public class ex16_8 {

	public static void main(String[] args) {
		int[] a = {300, 0 , -1 , -24, 17331, 1000000005, 100000, 101, 50000};
		
		for(int i : a){
			System.out.println("1 "+getIntAsString(i));
			System.out.println("2 " +getIntAsString2(i));
			System.out.println("3 "+ convertIntToString(i)+"\n");
			
		}
		
	}
	
	static String convertIntToString(int num){
		Map<Integer, String> map = new HashMap<>();
		initMap(map);
		if(num == 0){
			return "ZERO";
		}
		String[] prefixes = {"","THOUSAND","MILLION","BILLION"};
		StringBuilder result = new StringBuilder();
		if(num < 0){
			result.append("MINUS ");
			num*= -1;
		}
		Deque<String> stack = new LinkedList<>();
		
		for(int i = 0; i<4; i++){
			if(num == 0){
				break;
			}
			int chunk = num%1000;
			if(chunk != 0){
				String prefix = prefixes[i];
				if(prefix != ""){
					stack.push(prefix);
				}
				stack.push(getFirstThree(chunk, map));
			}
			num = num / 1000;
		}
		
		while(!stack.isEmpty()){
			result.append(stack.pop()).append(" ");
		}
		return result.toString();
	}
	
	static String getFirstThree(int num, Map<Integer, String> map){
		if(num == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int tens = num%100;
		int hundreds = num/100;
		
		if(hundreds > 0){
			sb.append(map.get(hundreds)).append(" ").append(map.get(100));
		}
		
		if(tens > 0){
			if(hundreds > 0){
				sb.append(" ");
			}
			sb.append(getFirstTwo(tens, map));
		}
		return sb.toString();
	}
	
	static String getFirstTwo(int num, Map<Integer, String> map){
		if(num < 21){
			return map.get(num);
		}
		if(num == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int ones = num%10;
		int tens = num-ones;
		sb.append(map.get(tens));
		if(ones>0){
			sb.append(" ").append(map.get(ones));
		}
		return sb.toString();
	}
	
	public static String getIntAsString2(int a){
		if(a == 0){
			return "Zero";
		}
		String[] prefix = {"Thousand","Million","Billion"};
		StringBuilder sb = new StringBuilder();
		if(a < 0){
			sb.append("Minus ");
			a*=-1;
		}
		List<String> list = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		initMap(map);
		int i = 0;
		while(a>0){
			int hundreds = a%1000;
			if(hundreds > 0){
				list.add(get3DigitsAsString(hundreds, map));
			}
			a = a/1000;
			if(a>0 && a %1000 >0){
				list.add(" ");
				list.add(prefix[i]);
			}
			i++;
		}
		for(int j = list.size()-1; j >=0; j--){
			sb.append(list.get(j));
		}
		return sb.toString();
	}
	public static String get3DigitsAsString(int a, Map<Integer, String> map){
		StringBuilder sb = new StringBuilder();
		int hundreds = a/100;
		if(hundreds > 0){
			sb.append(map.get(hundreds)).append(" ").append(map.get(100)).append(" ");
		}
		
		//handle tens
		int tens = a %100;
		if(tens > 0){
			if(tens < 20 || tens % 10 == 0){
				sb.append(map.get(tens)).append(" ");
			}
			else{
				sb.append(map.get(tens-(tens%10))).append(" ");
				sb.append(map.get(tens%10)).append(" ");
			}
		}
		return sb.toString();
	}
	
	
	
	public static String getIntAsString(int a){
		Deque<String> q = new LinkedList<>();
		Map<Integer, String> map = new HashMap<>();
		initMap(map);
		StringBuilder sb = new StringBuilder();
		if(a == 0){
			return "ZERO";
		}
		boolean isNegative = false;
		if(a<0){
			isNegative = true;
			a*=-1;
		}
		int divisor = 1;
		
		while (a>0){
			if(isSpecialCase(divisor)){
				int next = a%100;
				if(next<20){
					if(next >0){
						q.addFirst(map.get(next));
					}
				}
				else{
					if(next%10 != 0){
						q.addFirst(map.get(next%10));
						q.addFirst(map.get((next/10*10)));
					}
					else{
						q.addFirst(map.get(next));
					}
				}
				divisor *=100;
				a /= 100;
			}
			else{
				if(a%10 != 0){
					q.addFirst(map.get(a%10));
				}
				divisor *=10;
				a /= 10;
			}
			if(a>0){
				if(needToAddDescription(divisor) && (a%10 != 0 || a<1000)){
					q.addFirst(map.get(divisor));
				}
				if((divisor/1000==100 || divisor/1000000==100) && a%10 != 0){
					q.addFirst(map.get(100));
				}
			}
		}
		if(isNegative){
			sb.append("MINUS ");
		}
		for(String s : q){
			sb.append(s).append(" ");
		}
		return sb.toString().trim();
	}
	
	private static void initMap(Map<Integer, String> map) {
		map.put(1,"ONE");
		map.put(2,"TWO");
		map.put(3,"THREE");
		map.put(4,"FOUR");
		map.put(5,"FIVE");
		map.put(6,"SIX");
		map.put(7,"SEVEN");
		map.put(8,"EIGHT");
		map.put(9,"NINE");
		map.put(10,"TEN");
		map.put(11,"ELEVEN");
		map.put(12,"TWELVE");
		map.put(13,"THIRTEEN");
		map.put(14,"FOURTEEN");
		map.put(15,"FIFTEEN");
		map.put(16,"SIXTEEN");
		map.put(17,"SEVENTEEN");
		map.put(18,"EIGHTEEN");
		map.put(19,"NINETEEN");
		map.put(20,"TWENTY");
		map.put(30,"THIRTY");
		map.put(40,"FOURTY");
		map.put(50,"FIFTY");
		map.put(60,"SIXTY");
		map.put(70,"SEVENTY");
		map.put(80,"EIGHTY");
		map.put(90,"NINTY");
		map.put(100,"HUNDRED");
		map.put(1000,"THOUSAND");
		map.put(1000000,"MILLION");
		map.put(1000000000,"BILLION");
	}

	private static boolean isSpecialCase(int a){
		return a == 1 || a == 1000 || a == 1000000 || a == 1000000000;
	}
	
	private static boolean needToAddDescription(int a){
		return a==100 || a == 1000 || a == 1000000 || a == 1000000000 ;
	}
	

}
