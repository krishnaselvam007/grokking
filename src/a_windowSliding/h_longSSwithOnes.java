package a_windowSliding;

public class h_longSSwithOnes {

	/*Problem Statement #
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

Example 1:

Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.*/
	public static void main(String[] args) {
		System.out.println(rearrange(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
	}

	private static int rearrange(int[] is, int k) {
		int start = 0 , maxSize = 0 , maxCount = 0;
		for (int i = 0; i < is.length; i++) {
			if(is[i] == 1){
				maxCount++;
			}
			if(i - start - maxCount + 1 > k){
				if(is[start] == 1) maxCount--;
				start ++;
			}
			maxSize = Math.max(maxSize, i - start + 1);
		}
		return maxSize;
	}

}
