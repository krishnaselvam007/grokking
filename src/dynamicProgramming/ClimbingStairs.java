package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
public class ClimbingStairs {
	
	public static void main(String[] args) {
		System.out.println("No of Ways :: "+climbingstairs0(4));
		System.out.println("No of Ways :: "+climbingstairs1(5));
		System.out.println("No of Ways :: "+climbingstairs2(5));
		System.out.println("No of Ways :: "+climbingstairs3(5));
	}
	
	//DP + Optimization (Bottom Up Approach)
	private static int climbingstairs0(int i) {
		if (i == 1) return 1;
		if (i == 2) return 2;
		if (i <= 0) return 0;
		int oneStepBefore = 2, twoStepBefore = 1;
		for (int j = 2; j < i; j++) {
			int allways = oneStepBefore + twoStepBefore; // 3 / 5
			twoStepBefore = oneStepBefore; // 2 / 3
			oneStepBefore = allways; // 3 / 5
		}
		return oneStepBefore;
	}
	
	//Recustion (Top Down Approach)
	private static int climbingstairs1(int i) {
		if (i == 1 || i == 2) return i;
		if (i <= 0) return 0;
		return climbingstairs1(i-1)+climbingstairs1(i-2);
	}
	
	//Recursion + memorization (Top Down Approach)
	private static int climbingstairs2(int i) {
		Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
		memo.put(1, 1);
		memo.put(2, 2);
		return climbingstairs2(i, memo);
	}

	private static int climbingstairs2(int i, Map<Integer, Integer> memo) {
		if (memo.containsKey(i)) {
			return memo.get(i);
		}
		memo.put(i, climbingstairs2(i-1, memo)+climbingstairs2(i-2, memo));
		System.out.println(memo);
		return memo.get(i);
	}
	
	//Bottom up - DP
	private static int climbingstairs3(int i) {
		if (i == 1 || i == 2) return i;
		if (i <= 0) return 0;
		int[] dp = new int[i+1];
		dp[1] = 1;
		dp[2] = 2;
		for (int j = 3; j <= i; j++) {
			dp[j] = dp[j-1] + dp[j-2];
		}
		return dp[i];
	}

}
