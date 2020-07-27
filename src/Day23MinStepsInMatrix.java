/*
 * You are given an M by N matrix consisting of booleans that represents a board. 
 * Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 * 
 * Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps 
 * required to reach the end coordinate from the start. If there is no possible path, then return null. 
 * You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
 * 
 * For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), 
the minimum number of steps required to reach the end is 7, 
since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 * 
 */

public class Day23MinStepsInMatrix {

	public static void main(String[] args) {
		
		char grid[][] = {
				{'f', 'f', 'f', 'f'},
				{'t', 't', 'f', 't'},
				{'f', 'f', 'f', 'f'},
				{'f', 'f', 'f', 'f'}
		};
		int start[] = {3, 0};
		int end[] = {0, 0};
		
		System.out.println("The minimum steps to reach destination is: " + minSteps(grid, start, end));

	}
	
	private static int minSteps(char grid[][], int start[], int end[]) {
		
		if(grid == null || grid.length == 0) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = start[0]; i >= end[0]; i--) {
			for(int j = start[1]; j >= end[1]; j--) {
				if(grid[i][j] == 'f') {
					min = Math.min(min, dfs(grid, i, j)); 
				}
			}
		}
		return min;
	}
	
	private static int dfs(char grid[][], int i, int j) {
		
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 't') {
			return 0;
		}
		
		grid[i][j] = 't';
		int count = 1;
		count += dfs(grid, i-1, j);
		count += dfs(grid, i+1, j);
		count += dfs(grid, i, j-1);
		count += dfs(grid, i , j+1);
		
		return count;
		
	}

}
