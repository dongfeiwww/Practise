/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean row=false;
        boolean col=false;
        for(int i=0;i<matrix.length;i++)
            if(matrix[i][0]==0){
                row=true;
                break;
            }
        for(int j=0;j<matrix[0].length;j++)
            if(matrix[0][j]==0){
                col=true;
                break;
            }
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
        for(int i=1;i<matrix.length;i++)
            if(matrix[i][0]==0)
                for(int j=0;j<matrix[0].length;j++)
                    matrix[i][j]=0;
        for(int j=1;j<matrix[0].length;j++)
            if(matrix[0][j]==0)
                for(int i=0;i<matrix.length;i++)
                    matrix[i][j]=0;
        if(row)
            for(int i=0;i<matrix.length;i++)
                matrix[i][0]=0;
        if(col)
            for(int j=0;j<matrix[0].length;j++)
                matrix[0][j]=0;
    }
}
