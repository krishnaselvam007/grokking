package a_windowSliding;

import java.util.HashMap;

//Given a string, find the length of the longest substring in it with no more than K distinct characters.
public final class d_LongStringKDistinctChar {

	public static void main(String[] args) {
		System.out.println(longSubString("araaci",2));
	}

	private static int longSubString(String string, int i) {
		char[] str = string.toCharArray();
		int maxLength = 0, start = 0;
		HashMap<Character, Integer> chars = new HashMap<>();
		for (int j = 0; j < str.length; j++) {
			char rtChar = str[j];
			chars.put(rtChar, chars.getOrDefault(rtChar, 0) + 1);
			while (chars.size() > i) {
				char ltChar = str[start];
				chars.put(ltChar, chars.get(ltChar) - 1);
				if (chars.get(ltChar) == 0) {
					chars.remove(ltChar);
				}
				start++;
			}
			maxLength = Math.max(maxLength, j - start + 1);
		}
		return maxLength;
	}

}
