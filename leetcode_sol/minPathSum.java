/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i=1; i < rows; i++) 
            grid[i][0] += grid[i-1][0];
            
        for (int j=1; j < cols; j++) 
            grid[0][j] += grid[0][j-1];
            
        for (int i=1; i < rows; i++) {
            for (int j=1; j < cols; j++) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + + grid[i][j];
            }
        }
        return grid[rows-1][cols-1];
    }
}
