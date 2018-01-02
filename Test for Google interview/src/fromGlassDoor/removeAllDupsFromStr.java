package fromGlassDoor;

import java.util.HashSet;
import java.util.Set;

public class removeAllDupsFromStr {

	public static void main(String[] args) {
		System.out.println("oren --> " + removeAllDups("oreno"));
		System.out.println("oren --> " + removeAllDups("o r e   no"));
	}

	static String removeAllDups(String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException("can't be null or empty");
		}

		Set<Character> existingChars = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!existingChars.contains(c) && c != ' ') {
				existingChars.add(c);
				sb.append(c);
			}

		}
		return sb.toString();
	}

}
