import java.util.*;

public class Minesweeper {
  class Cell {
    int x,y;
    boolean isMine;
    boolean isClicked;
    boolean isFlagged;
    int numSurrounding;
    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
      isMine = false;
      isClicked = false;
      isFlagged = false;
      numSurrounding = 0;
    }
  }

  Cell[][] board;
  int width;
  int height;
  public void buildBoard(int width, int height, int numMines) {
    this.width = width;
    this.height = height;
    board = new Cell[width][height];
    int total = width*height;
    Set<Integer> candidates = new HashSet<Integer>();
    Random rn = new Random();
    while (candidates.size() < numMines) {
      candidates.add(rn.nextInt() % total);
    }

    for (Integer pos: candidates) {
      int x = pos % width;
      int y = pos / width;
      board[x][y].isMine = true;
      List<Cell> neighbours = findNeighbor(x, y);
      for (Cell c: neighbours) {
        c.numSurrounding++;
      }
    }
  }

  private List<Cell> findNeighbor(int x, int y) {
    List<Cell> neighbours = new ArrayList<Cell>();
    if (x>0)
      neighbours.add(board[x-1][y]);
    if (y>0)
      neighbours.add(board[x][y-1]);
    if (x<board.length-1)
      neighbours.add(board[x+1][y]);
    if (y<board[0].length-1)
      neighbours.add(board[x][y+1]);
    return neighbours;
  }

  public String click(int x, int y) {
    if (x> board.length || y > board[0].length)
      return "";
    Cell cell = board[x][y];
    if (cell.isMine)
      return "Game over";

    if (cell.isClicked)
      return "click before";

    cell.isClicked = true;
    if (cell.numSurrounding > 0)
       return "has mine";

    for (Cell c: findNeighbor(x, y)) {
      click(c.x, c.y);
    }
    return "";
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
