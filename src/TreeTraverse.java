
public class TreeTraverse {
  class Node {
    Node parent;
    Node left;
    Node right;
    int val;
  }
  void preOrder(Node root) {
    if (root == null) return;
    Node cur = root;
    while (cur != null) {
        System.out.println( cur.val);
        if (cur.left != null)
            cur = cur.left;
        else if (cur.right != null)
            cur = cur.right;
        else {
            while (cur.parent != null && cur != cur.parent.left)
                cur = cur.parent;
            if (cur.parent == null)
                break;
            else
                cur = cur.parent.right;
        }
    }

}
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
