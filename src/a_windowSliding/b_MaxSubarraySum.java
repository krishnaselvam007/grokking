package a_windowSliding;

//Given an array of positive numbers and a positive number ‘k’, 
//find the maximum sum of any contiguous subarray of size ‘k’.
public class b_MaxSubarraySum {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(findMaxSum(3, new int[] {2, 1, 5, 1, 3, 2}));
		long endTime = System.nanoTime();
		System.out.println(endTime-startTime);
	}

	private static int findMaxSum(int i, int[] js) {
		int maxSum = 0 ;
		for (int j = 0; j < js.length-i+1; j++) {
			int sum =0;
			for (int j2 = j; j2 < j+i; j2++) {
				sum += js[j2];
			}
			maxSum = Math.max(sum, maxSum);
		}
		
		return maxSum;
	}
	
	private static int findMaxSum1(int i, int[] js) {
		int sum = 0 , maxSum = 0 , start = 0;
		for (int j = 0; j < js.length; j++) {
			sum += js[j];
			if (j >= i-1) {
				maxSum = Math.max(sum, maxSum);
				sum -= js[start];
				start ++;
			}
		}
		return maxSum;
	}

}
