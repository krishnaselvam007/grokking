package b_twoPointer;

import java.util.HashMap;

/*Problem Statement #
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6*/

public class a_PairTargetSum {

	public static void main(String[] args) {
		int[] res = pairTargetSum(new int[] {1, 2, 3, 4, 6}, 6);
		System.out.println(res[0] + " "+res[1]);
	}

	private static int[] pairTargetSum1(int[] is, int i) {
		HashMap<Integer, Integer> sums = new HashMap<>();
		for (int j = 0; j < is.length; j++) {
			if (sums.containsKey(i - is[j])) {
				return new int[] {sums.get(i-is[j]), j };
			}
			sums.put(is[j], j);
		}
		return new int[] {-1,-1};
	}

	private static int[] pairTargetSum(int[] is, int i) {
		int left = 0 , right = is.length-1 ;
		while (left < right) {
			int currentSum = is[left] + is[right];
			if(currentSum == i) return new int[] {left,right};
			if(currentSum > i) right --;
			else left++;
		}
		return new int[] {-1,-1};
	}

}
