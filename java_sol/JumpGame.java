import java.util.*;
public class JumpGame {
  static Set<Integer> visited = new HashSet<Integer>();
  static boolean canWin(int[] board, int pos) {
    if (pos<0 || pos >= board.length)
      return false;
    else if (visited.contains(pos))
      return false;

    visited.add(pos);
    if (board[pos] == 0)
      return true;
    else {
      if (visited.size() == board.length)
        return false;
      return canWin(board, pos-board[pos]) || canWin(board, pos+board[pos]);
    }
  }

  public static void main(String[] args) {
    int[] board = {1,2,1,0,3};
    System.out.println(canWin(board, 0));
  }
}
