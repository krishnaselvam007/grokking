package dynamicProgramming;

public class Knapsack {

	public static void main(String[] args) {
		int[] weights = {2,3,1,4};
		int[] profits = {4,5,3,7};
		int maxprofit = bruteForceSol(profits, weights, 5);
		System.out.println(maxprofit);
		maxprofit = topDownMemorization(profits, weights, 5);
		System.out.println(maxprofit);
		maxprofit = bottomUpDP(profits, weights, 5);
		System.out.println(maxprofit);
	}

	//depth-first
	private static int bruteForceSol(int[] profits, int[] weights, int capacity) {
		return bruteForceSol(profits, weights, capacity, 0);
	}

	private static int bruteForceSol(int[] profits, int[] weights, int capacity, int currentIndex) {
		if (capacity <= 0 || currentIndex >= profits.length) return 0;
		int profit1 = 0;
		if (weights[currentIndex] <= capacity) {
			profit1 = profits[currentIndex] + bruteForceSol(profits, weights, capacity - weights[currentIndex], currentIndex+1);
		}
		int profit2 = bruteForceSol(profits, weights, capacity, currentIndex+1);
		return Math.max(profit1, profit2);
	}
	
	//Top-down Dynamic Programming with Memoization
	private static int topDownMemorization(int[] profits, int[] weights, int capacity) {
		Integer[][] dp = new Integer[profits.length][capacity+1];
		return topDownMemorization(dp, profits, weights, capacity, 0);
	}

	private static int topDownMemorization(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
		if(capacity <= 0 || currentIndex >= profits.length) return 0;
		if (dp[currentIndex][capacity] != null) return dp[currentIndex][capacity];
		int profit1 = 0;
		if(weights[currentIndex] <= capacity) profit1 = profits[currentIndex] + topDownMemorization(dp, profits, weights, capacity-weights[currentIndex], currentIndex+1);
		int profit2 = topDownMemorization(dp, profits, weights, capacity, currentIndex+1);
		dp[currentIndex][capacity] = Math.max(profit1, profit2);
		return dp[currentIndex][capacity];
	}
	
	//Bottom-up Dynamic Programming
	private static int bottomUpDP(int[] profits, int[] weights, int capacity) {
		if(capacity <= 0 || profits.length == 0 || weights.length != profits.length) return 0;
		int n = profits.length;
		int[][] dp = new int[n][capacity+1];
		for (int i = 0; i < n; i++) dp[i][0] = 0;
		for (int i = 0; i <= capacity; i++) {
			if (weights[0] <= i) dp[0][i] = profits[0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= capacity; j++) {
				int profit1 = 0, profit2 = 0;
				if (weights[i] <= j) profit1 = profits[i] + dp[i-1][j-weights[i]];
				profit2 = dp[i-1][j];
				dp[i][j] = Math.max(profit1, profit2);
			}
		}
		return dp[n-1][capacity];
	}
}
