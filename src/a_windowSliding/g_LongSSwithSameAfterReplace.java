package a_windowSliding;

import java.util.HashMap;

public class g_LongSSwithSameAfterReplace {

	public static void main(String[] args) {
/*		Problem Statement #
		Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

		Example 1:

		Input: String="aabccbb", k=2
		Output: 5
		Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
		Example 2:

		Input: String="abbcb", k=1
		Output: 4
		Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".*/
		System.out.println(search("abbcb",1));
	}

	private static int search(String str, int k) {
		int start = 0 , maxSize = 0 , maxLength = 0;
		HashMap<Character, Integer> chars = new HashMap<>();
		for (int end = 0; end < str.length(); end++) {
			char a = str.charAt(end);
			chars.put(a, chars.getOrDefault(a, 0)+1);
			maxSize = Math.max(maxSize, chars.get(a));
			//here is trick
			//System.out.println("map size :: "+chars.size());
			//System.out.println(end - start + 1 - maxSize);
			if(end - start + 1 - maxSize > k) {
				System.out.println("Inside");
				char b = str.charAt(start);
				chars.put(b, chars.get(b)-1);
				start ++;
			}
			maxLength = Math.max(maxLength, end - start + 1 );
		}
		return maxLength;
	}

}
