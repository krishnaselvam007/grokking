package a_windowSliding;

//Given an array of positive numbers and a positive number ‘S’, 
//find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. 
//Return 0, if no such subarray exists.
public class c_SmallSubArraySum {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(smallSubArray(6, new int[] { 2, 1, 5, 2, 3, 2 }));
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
	}

	private static int smallSubArray(int i, int[] js) {
		int sum = 0, start = 0, length = Integer.MAX_VALUE;
		for (int j = 0; j < js.length; j++) {
			sum += js[j];
			while (sum >= i) {
				sum -= js[start];
				length = Math.min(length, j + 1 - start);
				start++;
			}
		}
		return length == Integer.MAX_VALUE ? 0 : length;
	}

}
