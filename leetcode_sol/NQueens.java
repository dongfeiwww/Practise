/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
public class Solution {
    private ArrayList<String[]> ret=new ArrayList<String[]>();
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) return new ArrayList<String[]>();
        ret.clear();
        boolean[] used=new boolean[n];
        int[] flag=new int[n];
        solve(0,n,ret,used,flag);
        return ret;
    }

    public void solve(int row,int n,ArrayList<String[]> ret,boolean[] used,int[] flag){
        if(row==n){
            String[] cur=new String[n];
            for(int i=0;i<n;i++){
                char[] temp=new char[n];
                for(int j=0;j<n;j++){
                    if(j==flag[i]) temp[j]='Q';
                    else temp[j]='.';
                }
                cur[i]=new String(temp);
            } 
            ret.add(cur);           
            return;
        }

        for (int i=0;i<n;i++){
            flag[row]=i;
            if(used[i]==false&&check(row,i,flag)==true){
                used[i]=true;
                solve(row+1,n,ret,used,flag);
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
