class Solution {
  int m,n;
  int[] dy = {-1,-1,0,1,1,1,0,-1};
  int[] dx = {0,1,1,1,0,-1,-1,-1};
  public char[][] updateBoard(char[][] board, int[] click) {
      m = board.length; n = board[0].length;
      dfs(board, click[0], click[1]);
      return board;
  }
  
  private void dfs(char[][] board, int x, int y) {
      if (x < 0 || x >= m || y < 0 || y >= n) return;
      if (board[x][y] == 'M') {
          board[x][y] = 'X';
          return;
      } else if (board[x][y] == 'E'){
          int num = numOfM(board, x, y);
          if (num > 0) {
              board[x][y] = (char) (num + '0');
          } else {
              board[x][y] = 'B';
              for (int i = 0; i < dy.length; i++) {
                  dfs(board, x + dx[i], y + dy[i]);
              }
          }
      }
  }
  
  private int numOfM(char[][] board, int x, int y) {
      int num = 0;   
      for (int i = x - 1; i <= x + 1; i++) {
          for (int j = y - 1; j <= y + 1; j++) {
              if (i >= 0 && j >= 0 && i < m && j < n && board[i][j] == 'M')
                  num += 1;
          }   
      }
      return num;
  }
}