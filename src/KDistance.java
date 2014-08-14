import java.util.*;

public class KDistance {
  static class Node {
    char c;
    boolean isLeaf;
    Node p;
    Map<Character, Node> children;
    String word;
    int no;
    int depth;
    static int counter = 0;
    static Map<Integer, Node> nodemap = new HashMap<Integer, Node>();

    public Node(Node parent, char c) {
      children = new HashMap<Character, Node>();
      p = parent;
      if (p == null)
        depth = 0;
      else
        depth = p.depth + 1;
      this.c = c;
      isLeaf = false;
      no = counter++;
      nodemap.put(no, this);
    }

    public void addChild(char c) {
      assert (children.get(c) == null);
      children.put(c, new Node(this, c));
    }

    public Node getChild(char c) {
      return children.get(c);
    }

    public static Node findNode(int num) {
      assert (num < counter);
      return nodemap.get(num);
    }
  };

  public Node constructTrie(String[] dict) {
    Node root = new Node(null, ' ');
    for (int i = 0; i < dict.length; i++) {
      Node ptr = root;
      for (int j = 0; j < dict[i].length(); j++) {
        char c = dict[i].charAt(j);
        if (ptr.getChild(c) == null)
          ptr.addChild(c);
        ptr = ptr.getChild(c);
      }

      ptr.isLeaf = true;
      ptr.word = dict[i];
    }
    return root;
  }

  public void printKDistanceWithTrie(String target, Node ptr, int k) {
    int m = target.length() + 1;
    int n = Node.counter;
    int[][] matrix = new int[m][n];
    int i, j;
    for (i = 0; i < m; i++)
      matrix[i][0] = i;
    for (j = 0; j < n; j++)
      matrix[0][j] = Node.findNode(j).depth;

    for (j = 1; j < n; j++) {
      for (i = 1; i < m; i++) {
        Node node = Node.findNode(j);
        if (target.charAt(i - 1) == node.c) {
          matrix[i][j] = matrix[i - 1][node.p.no];
        } else {
          matrix[i][j] = Math.min(matrix[i - 1][j] + 1, matrix[i][node.p.no] + 1);
          matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][node.p.no] + 1);
        }

        if (i == m - 1 && node.isLeaf == true && matrix[i][j] <= k) {
          System.out.println(node.word);
        }
      }
    }
  }

  int editDist(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();

    int[][] m = new int[len1 + 1][len2 + 1];
    //m[0][0]=0;
    //init the matrix
    for (int i = 0; i <= len1; i++) {
      m[i][0] = i;
    }

    for (int j = 0; j <= len2; j++)
      m[0][j] = j;

    //then update the matrix
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1))
          m[i][j] = m[i - 1][j - 1];
        else {
          m[i][j] = Math.min(m[i - 1][j - 1] + 1, m[i - 1][j] + 1);
          m[i][j] = Math.min(m[i][j], m[i][j - 1] + 1);
        }
      }
    }

    return m[len1][len2];
  }

  List<String> getKEditDistance(String word, String[] word_list, int k) {
    int n = word_list.length;
    if (n < 1)
      return null;
    List<String> ret = new ArrayList<String>();
    for (int i = 0; i < n; i++) {
      if (editDist(word, word_list[i]) <= k) {
        ret.add(word_list[i]);
      }
    }

    return ret;
  }

  public static void main(String[] args) {
    KDistance kinst = new KDistance();
    String[] input = new String[] { "dat", "bat", "batt", "beetle" };
    String target = "datt";
    Node root = kinst.constructTrie(input);
    kinst.printKDistanceWithTrie(target, root, 1);
    System.out.println(kinst.getKEditDistance(target, input, 1));
  }
}