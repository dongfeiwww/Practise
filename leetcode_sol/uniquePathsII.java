/*
Follow up for "Unique Paths": Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid. For example, There is one obstacle in the middle of a 3x3 grid as illustrated below. [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2. Note: m and n will be at most 100.
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        int[][] f=new int[obstacleGrid.length][obstacleGrid[0].length];
        f[0][0]=obstacleGrid[0][0]==1?0:1;
        for(int i=1;i<obstacleGrid.length;i++)
            f[i][0]=obstacleGrid[i][0]==1?0:f[i-1][0];
        for(int j=1;j<obstacleGrid[0].length;j++)
            f[0][j]=obstacleGrid[0][j]==1?0:f[0][j-1];
        for(int i=1;i<obstacleGrid.length;i++)
            for(int j=1;j<obstacleGrid[0].length;j++)
                f[i][j]=obstacleGrid[i][j]==1?0:f[i-1][j]+f[i][j-1];
        return f[obstacleGrid.length-1][obstacleGrid[0].length-1];
 
    }
}
