package a_windowSliding;

import java.util.Arrays;

//Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
public class a_averageOfSubarray {

	
	public static void main(String[] args) {
		int[] list = {1, 3, 2, 6, -1, 4, 1, 8, 2, 2,6,7,8,9,4,5,6,3,3,21,3,45,5,6,6,8,6,4,3,2,2,3,4,5,6,6,6};
		int k = 3;
		long startTime = System.nanoTime();
		double[] res = a_averageOfSubarray.findAverageSum(k,list);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(res));
		System.out.println("Time Taken :: "+(endTime - startTime));
	}

	private static double[] findAverageSum(int k, int[] list) {
		double[] res = new double[list.length-k+1];
		int sum = 0, windowStart = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
			if(i >= k-1) {
				res[windowStart] = sum/k;
				sum -= list[windowStart];
				windowStart++;
			}
		}
		return res;
	}

	private static double[] findAverageSum1(int k, int[] list) {

		double[] res = new double[list.length-k+1];
		for (int i = 0; i <= list.length - k; i++) {
			double sum = 0;
			for (int j = i; j < i+k; j++) {
				sum += list[j];
			}
			res[i] = sum/k;
		}
		return res;
	}
	
	

}
