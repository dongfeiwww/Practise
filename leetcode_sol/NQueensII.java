/*
Follow up for N-Queens problem. Now, instead outputting board configurations, return the total number of distinct solutions.
*/
public class Solution {
    private int ret;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ret=0;
        int[] flag=new int[n];
        boolean[] used=new boolean[n];
        solve(0,n,used,flag);
        return ret;
    }
    public void solve(int row,int n,boolean[] used,int[] flag){
        if(row==n){
            ret++;
            return;
        }
        for(int i=0;i<n;i++){
            flag[row]=i;
            if(used[i]==false&&check(row,i,flag)==true){
                used[i]=true;
                solve(row+1,n,used,flag);
                used[i]=false;
            }
        }
    }
    public boolean check(int row,int col,int[] flag){
        for(int i=0;i<row;i++)
            if(Math.abs(row-i)==Math.abs(col-flag[i]))
                return false;
        return true;
    }
}
