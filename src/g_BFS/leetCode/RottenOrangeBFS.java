package g_BFS.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.*/

/*Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.*/

public class RottenOrangeBFS {
	
	public static void main(String[] args) {
		int[][] grid = new int[3][3];
		grid[0][0] = 2;
		grid[0][1] = 1;
		grid[0][2] = 1;
		grid[1][0] = 0;
		grid[1][1] = 1;
		grid[1][2] = 1;
		grid[2][0] = 1;
		grid[2][1] = 0;
		grid[2][2] = 1;
		System.out.println("result :: "+orangeRottens(grid));
	}

	private static int orangeRottens(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		int row = grid.length;
		int col = grid[0].length;
		int freshO = 0;
		Queue<int[]> rottenOranges = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				//store the position of rotten orange
				if (grid[i][j] == 2) rottenOranges.offer(new int[] {i,j});
				//count the fresh orange
				else if (grid[i][j] == 1) freshO++;
			}
		}
		System.out.println(freshO);
		
		if(freshO == 0) return 0;
		int minCount = 0; // every minute the orange will rotten
		
		int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
		
		while (!rottenOranges.isEmpty()) {
			++minCount;
			int size = rottenOranges.size();
			for (int i = 0; i < size; i++) {
				int[] point = rottenOranges.poll();
				System.out.println(Arrays.toString(point));
				for(int[] dir: dirs) {
					int x = point[0] + dir[0]; // adjacent position of rotten orange
					int y = point[1] + dir[1]; // adjacent position of rotten orange
					
					if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 2 || grid[x][y] == 0) {
						continue;
					}else {
						grid[x][y] = 2; // make orange rotten
						rottenOranges.offer(new int[] {x,y}); // store the position of new rotten orange
						freshO--; // decrease fresh orange
					}
				}
			}
		}
		System.out.println(freshO);
		System.out.println(minCount);
		return freshO == 0 ? minCount-1 : -1;
	}

}
