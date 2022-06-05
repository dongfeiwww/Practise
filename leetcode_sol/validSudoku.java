/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidStrip(board)&&isValidBlock(board);
    }
    public boolean isValidRectangle(char[][] board,int x1,int y1,int x2,int y2){
        int[] count=new int[256];
        Arrays.fill(count,0);
        for(int i=x1;i<=x2;i++){
            for(int j=y1;j<=y2;j++){
                if(board[i][j]>='0'&&board[i][j]<='9'){ 
                    if(++count[board[i][j]]>1)
                        return false;
        }
                else if(board[i][j]!='.')
                    return false;
            }
        }
        return true;
    }
    public boolean isValidStrip(char[][] board){
        int n=board.length;
        for(int i=0;i<n;i++)
            if(!isValidRectangle(board,i,0,i,n-1))
                return false;
        for(int j=0;j<n;j++)
            if(!isValidRectangle(board,0,j,n-1,j))
                return false;
        return true;
    }
    public boolean isValidBlock(char[][] board){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(!isValidRectangle(board,3*i,3*j,3*i+2,3*j+2))
                    return false;
        return true;
    }
}
