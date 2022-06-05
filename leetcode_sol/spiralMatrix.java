/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order. For example, Given the following matrix: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return [1,2,3,6,9,8,7,4,5].
*/
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) return result;
        int xBeg=0,xEnd=matrix.length-1;
        int yBeg=0,yEnd=matrix[0].length-1;
        while(true){
            for(int i=yBeg;i<=yEnd;i++) result.add(matrix[xBeg][i]);
            if(++xBeg>xEnd) break;
            for(int i=xBeg;i<=xEnd;i++) result.add(matrix[i][yEnd]);
            if(--yEnd<yBeg) break;
            for(int i=yEnd;i>=yBeg;i--) result.add(matrix[xEnd][i]);
            if(--xEnd<xBeg) break;
            for(int i=xEnd;i>=xBeg;i--) result.add(matrix[i][yBeg]);
            if(++yBeg>yEnd) break;
        }
        return result;
 
    }
}
