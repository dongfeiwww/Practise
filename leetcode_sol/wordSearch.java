/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word==null||word.length()==0) return false;
        char[] ch=word.toCharArray();
        int maxLen = ch.length;
        int m = board.length;
        if(m==0) return false;
        int n=board[0].length;

        boolean[][] visited=new boolean[m][n];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(board[i][j]==ch[0])
                    if(dfs(board,ch,i,j,0,m,n,maxLen,visited)) return true;
        return false;
    }

    public boolean dfs(char[][] board,char[]ch,int i,int j,int len,int m,int n,int maxLen,boolean[][] visited){
        if(len==maxLen) 
          return true;

        if(i>=m||j>=n||i<0||j<0) 
          return false;

        if (visited[i][j]|| board[i][j]!=ch[len]) 
          return false;

        visited[i][j]=true;

        if(dfs(board,ch,i-1,j,len+1,m,n,maxLen,visited)||
           dfs(board,ch,i+1,j,len+1,m,n,maxLen,visited)||
           dfs(board,ch,i,j-1,len+1,m,n,maxLen,visited)||
           dfs(board,ch,i,j+1,len+1,m,n,maxLen,visited))
           return true;

        visited[i][j]=false;

        return false;
    }
}
