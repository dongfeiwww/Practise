import java.util.*;

public class KDistance2 {
  static class Node {
    char c;
    boolean isLeaf;
    String word;
    Node parent;
    HashMap<Character, Node> children;
    int depth;
    int no;
    static int count = 0;
    static Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();

    public Node(Node parent, char c) {
      this.parent = parent;
      children = new HashMap<Character, Node>();
      if (parent == null)
        depth = 0;
      else
        depth = this.parent.depth+1;
      this.c = c;
      isLeaf = false;
      no = count++;
      nodeMap.put(no, this);
    }

    public void addChild(char c) {
      if (!children.containsKey(c))
        children.put(c, new Node(this, c));
    }

    public Node getChild(char c) {
      return children.get(c);
    }

    public static Node findNode(int num) {
      return nodeMap.get(num);
    }
  }

  public Node buildTrie(String[] words) {
    Node root = new Node(null, ' ');
    for (String word: words) {
      Node pointer = root;
      for (char c: word.toCharArray()) {
       // if (pointer.getChild(c) == null)
        pointer.addChild(c);
        pointer = pointer.getChild(c);
      }
      pointer.isLeaf = true;
      pointer.word = word;
    }
    return root;
  }

  public List<String> getKEditDistanceInTrie(String[] input, String target, int k) {
    List<String> result = new ArrayList<String>();
    int tLen = target.length() + 1;
    int nLen = Node.count;
    int[][] m = new int[tLen][nLen];
    for (int i=0; i<tLen; i++)
      m[i][0] = i;
    for (int i=0; i<nLen; i++)
      m[0][i] = Node.findNode(i).depth;

    for (int i=1; i<tLen; i++)
      for (int j=1; j<nLen; j++) {
        Node n = Node.findNode(j);
        if (target.charAt(i-1) == n.c) {
          m[i][j] = m[i-1][n.parent.no];
        } else {
          m[i][j] = Math.min(m[i-1][j], Math.min(m[i-1][n.parent.no], m[i][n.parent.no])) + 1;
        }

        if (i == tLen - 1 && n.isLeaf == true && m[i][j] <= k)
          result.add(n.word);
      }

    return result;
  }

  public KDistance2() {
  }

  List<String> getKEditDistance(String[] input, String target, int k) {
    List<String> result = new ArrayList<String>();
    for (String s: input) {
      int distance = getEditDistance(s, target);
      if (distance <= k)
        result.add(s);
    }
    return result;
  }

  private int getEditDistance(String s, String target) {
    int len1 = s.length();
    int len2 = target.length();
    int[][] m = new int[len1+1][len2+1];
    for (int i=0; i<=len1; i++)
      m[i][0] = i;
    for (int j=0; j<=len2; j++)
      m[0][j] = j;

    for (int i=1; i<=len1; i++)
      for (int j=1; j<=len2; j++) {
        if (s.charAt(i-1) == target.charAt(j-1)) {
          m[i][j] = m[i-1][j-1];
        } else {
          m[i][j] = Math.min(m[i-1][j-1], Math.min(m[i-1][j], m[i][j-1])) + 1;
        }
      }
    return m[len1][len2];
  }

  public static void main(String[] args) {
    KDistance2 kinst = new KDistance2();
    String[] input = new String[] { "dat", "bat", "batt", "beetle" };
    String target = "datt";
    Node root = kinst.buildTrie(input);
    System.out.println(kinst.getKEditDistanceInTrie(input, target, 1));
    System.out.println(kinst.getKEditDistance(input, target, 1));
  }
}
