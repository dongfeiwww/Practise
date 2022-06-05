/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
https://gist.github.com/luoxiaoxun/5801944
*/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        if(n==0) return 0;
        int[] L=new int[n];
        int[] R=new int[n];
        int[] H=new int[n];
        int maxArea=0;
        for(int i=0;i<n;i++){
            L[i]=-1;
            R[i]=n;
            H[i]=0;
        }
        for(int i=0;i<m;i++){
            int nearLeft=-1;
            for(int j=0;j<n;j++){
                L[j]=Math.max(nearLeft,L[j]);
                if(matrix[i][j]=='0'){
                    L[j]=-1;
                    H[j]=0;
                    nearLeft=j;
                }else H[j]++;
            }
            int nearRight=n;
            for(int j=n-1;j>=0;j--){
                R[j]=Math.min(nearRight,R[j]);
                if(matrix[i][j]=='0'){
                    R[j]=n;
                    nearRight=j;
                }
                maxArea=Math.max(maxArea,H[j]*(R[j]-L[j]-1));
            }
        }
        return maxArea;
    }
}
