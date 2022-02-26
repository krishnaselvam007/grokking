package g_BFS.leetCode;

public class RottenOrange {
	
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
		if(grid == null || grid.length == 0) return -1;
		int fresh = 0, min = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j]==1) fresh++;
			}
		}
		for (int i = fresh ; fresh > 0 ; min++, i = fresh) {
			for (int j = 0; j < grid.length; j++) {
				for (int k = 0; k < grid[j].length; k++) {
					if (grid[j][k] == min+2) {
						fresh -= rot(grid, j+1, k, min) + rot(grid, j-1, k, min) + rot(grid, j, k+1, min) + rot(grid, j, k-1, min);
					}
					if(i==fresh) return -1;
				}
			}
		}
		return min;
	}

	private static int rot(int[][] grid, int i, int j, int min) {
		if (i > 0 || j > 0 || i<= grid.length || j<= grid[0].length || grid[i][j] != 1) return 0;
		grid[i][j] = min+3;
		return 1;
	}

}
