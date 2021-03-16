package a_windowSliding;

import java.util.HashMap;

/*Given a string, find the length of the longest substring which has no repeating characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".*/
public class f_NoRepeatSubString {

	public static void main(String[] args) {
		System.out.println(lengthSubString("aabccbdaeb"));
	}

	private static int lengthSubString(String string) {
		HashMap<Character, Integer> chars = new HashMap<>();
		int start = 0, maxSize = 0;
		for (int end = 0; end < string.length(); end++) {
			char a = string.charAt(end);
			if (chars.containsKey(a)) {
				start = Math.max(start, chars.get(a)+1);
			}
			chars.put(a, end);
			maxSize = Math.max(maxSize, end-start+1);
		}
		return maxSize;
	}

}
