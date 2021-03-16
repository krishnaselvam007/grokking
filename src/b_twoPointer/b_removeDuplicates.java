package b_twoPointer;

/*Problem Statement #
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
*/
public class b_removeDuplicates {

	public static void main(String[] args) {
		
		//System.out.println(rDuplicates(new int[] {2, 3, 3, 3, 6, 9, 9, 10}));
/*		Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.

				Example 1:

				Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
				Output: 4
				Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].*/
		System.out.println(removeKey(new int[] {2, 3, 3, 3, 6, 9, 9, 10} , 3));
	}

	private static int removeKey(int[] is, int i) {
		int a = 0;
		for (int j = 0; j < is.length; j++) {
			if(is[j] != i) {
				is[a] = is[j];
				a++;
			}
		}
		return a;
	}

	private static int rDuplicates(int[] is) {
		int a = 1;
		for (int i = 1; i < is.length; i++) {
			if(is[a-1] != is[i]) {
				is[a] = is[i];
				a++;
			}
		}
		return a;
	}

}
