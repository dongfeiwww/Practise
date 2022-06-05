//There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
// https://leetcode.com/articles/the-maze/
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        int rows = maze.length, cols = maze[0].length;
        return traverse(maze, start, destination, new boolean[maze.length][maze[0].length], rows, cols, directions);
    }
    
    boolean traverse(int[][] m, int[] curr, int[] end, boolean[][] v, int rows, int cols, int[][] directions)
    {
        if(v[curr[0]][curr[1]]) return false;
        
        v[curr[0]][curr[1]] = true;
        
        // checking about weather we rech dest or not
        if(curr[0] == end[0] && curr[1] == end[1]) return true;
        
        boolean res = false;
        int x = 0, y = 0;
        
        for(int[] dir : directions)
        {
            x = curr[0];
            y = curr[1];
            
            // reaching the farthest point in each direction via checking wall & edge.
            while(x+dir[0] >= 0 && x+dir[0] < rows && y+dir[1] >= 0 && y+dir[1] < cols && m[x+dir[0]][y+dir[1]] != 1)
            {
                x += dir[0];
                y += dir[1];
            }
            
            res = res || traverse(m, new int[] {x,y}, end, v, rows, cols, directions);
            
            // If we find any reachable point then we wont go further to check. 
            if(res) return true;
        }
        return false;
    }
}