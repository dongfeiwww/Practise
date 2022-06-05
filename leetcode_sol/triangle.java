/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        
        ArrayList<int[]> dp = new ArrayList<int[]>();
        
        for(int i = 0; i < triangle.size() - 1; i++){
            dp.add(new int[i + 1]);
        }
        
        return find(dp, 0, 0, triangle);
         
    }
    
    public int find(ArrayList<int[]> dp, int row, int colum, ArrayList<ArrayList<Integer>> triangle){
        if(row == triangle.size() - 1){
            return triangle.get(row).get(colum);
        }
        
        if(dp.get(row)[colum] == 0){
            dp.get(row)[colum] = triangle.get(row).get(colum) + 
                Math.min(find(dp, row + 1, colum, triangle), find(dp, row + 1, colum + 1, triangle));
        }
        
        return dp.get(row)[colum];
    }
}
