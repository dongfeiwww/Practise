import java.util.*;
public class BinaryTree {

  static class Node {
    Node left;
    Node right;
    int value;
    public Node(int v) {
      value = v;
    }
  }

  static void printLevel(Node root) {

    if (root == null)
      return;

    Queue<Node> queue = new LinkedList<Node>();
    int cur = 1;
    int next = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      System.out.print(node.value + " ");
      cur--;
      if (node.left != null) {
        queue.add(node.left);
        next++;
      }
      if (node.right != null) {
        queue.add(node.right);
        next++;
      }
      if (cur == 0) {
        System.out.println();
        cur = next;
        next = 0;
      }

    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);

    one.left = two;
    one.right = five;
    two.right = four;
    four.left = three;
    five.left = six;

    printLevel(one);
  }

}
