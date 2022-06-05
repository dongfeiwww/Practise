
public class BSTree2 {
  class Node {
    Node left;
    Node right;
    Node parent;
    int value;
    public Node(int value) {
      this.value = value;
      right = left = parent = null;
    }
  }

  int count(Node root) {
    if (root == null) return 0;
    return count(root.left) + count(root.right) + 1;
  }

  Node root;
  public BSTree2() {
    root = null;
  }

  public Node addNode(int value) {
    Node one = new Node(value);
    if (root == null) {
      root = one;
      return one;
    }

    Node node = root;
    while (true) {
      if (node.value > value) {
        if (node.left == null) {
          node.left = one;
          one.parent = node;
          break;
        }
        node = node.left;
      } else {
        if (node.right == null) {
          node.right = one;
          one.parent = node;
          break;
        }
        node = node.right;
      }
    }
    return one;
  }

  public Node findNode(int value) {
    Node node = root;
    while (node != null) {
      if (node.value == value)
        return node;
      else if (node.value > value)
        node = node.left;
      else
        node = node.right;
    }
    return null;
  }

  public boolean deleteNode(int value) {
    Node node = findNode(value);
    if (node == null)
      return false;

    Node replaceOne;
    if (node.left == null && node.right == null) {
      replaceOne = null;
    } else if (node.left != null) {
      replaceOne = node.left;
      while (replaceOne.right != null)
        replaceOne = replaceOne.right;
    } else {
      replaceOne = node.right;
      while (replaceOne.left != null)
        replaceOne = replaceOne.left;
    }

    // update replaceNode
    if (replaceOne != null) {
      replaceOne.left = node.left;
      replaceOne.right = node.right;
      replaceOne.parent = node.parent;
    }

    // update parent
    Node parent = node.parent;
    if (parent == null)
      root = replaceOne;
    else if (parent.left == node)
      parent.left = replaceOne;
    else if (parent.right == node)
      parent.right = replaceOne;

    // set node pointers to null
    node.left = node.right = node.parent = null;
    return true;
  }

  public Node KThLargest(int k, Node root)
  {
    int lsize = 0;

    if (root == null)
    return null;

    // size of right subtree
    if (root.left != null)
      lsize = count(root.left);

    if (k == lsize + 1)
      return root;

    return k <= lsize? KThLargest(k, root.left): KThLargest((k - lsize - 1), root.right);
  }

  public static void main(String[] args) {
    BSTree2 bst = new BSTree2();
    bst.addNode(2);
    bst.addNode(1);
    bst.addNode(3);
    bst.addNode(0);
    System.out.println("root:" + bst.root.value);
    bst.deleteNode(2);
    System.out.println("root:" + bst.root.value);
  }
}
