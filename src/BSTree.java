
public class BSTree {
  class Node {
    int _value;
    Node _left;
    Node _right;
    Node _parent;
    public Node(int value) {
      _value = value;
      _left = null;
      _right = null;
      _parent = null;
    }
  }

  Node _root;
  public BSTree() {
    _root = null;
  }

  public Node addNode(int value) {
    Node one = new Node(value);
    if (_root == null) {
      _root = one;
      return one;
    }

    Node node = _root;
    while (true) {
      if (value < node._value) {
        if (node._left == null) {
          node._left = one;
          one._parent = node;
          break;
        }
        node = node._left;
      } else {
        if (node._right == null) {
          node._right = one;
          one._parent = node;
          break;
        }
        node = node._right;
      }
    }
    return one;
  }

  public Node findNode(int value) {
    Node node = _root;
    while (node != null) {
      if (value == node._value)
          return node;
      else if (value < node._value) {
        node = node._left;
      } else {
        node = node._right;
      }
    }
    return null;
  }

  public boolean deleteNode(int value) {
    Node node = findNode(value);
    if (node == null)
      return false;
    else {
      Node replaceOne;
      // if it has left subtree, replace the node with largest node in left subtree
      if (node._left != null) {
        replaceOne = node._left;
        while (replaceOne._right != null)
          replaceOne = replaceOne._right;
      } else {
        // only have right subtree, replace the node with smallest node in right subtree
        replaceOne = node._right;
        while (replaceOne._left != null)
          replaceOne = replaceOne._left;
      }

      // Got the replace node, it must be a leaf; now place it at the place where node is deleted
      replaceOne._left = node._left;
      replaceOne._right = node._right;
      replaceOne._parent = node._parent;
      Node parent = node._parent;
      if (parent != null) {
        if (parent._right == node)
          parent._right = replaceOne;
        else
          parent._left = replaceOne;
      } else
        _root = replaceOne;

      node._left = null;
      node._right = null;
      node._parent = null;

      return true;
    }
  }

  Node parent = null;
  boolean deleteNode2(int value) {
    return deleteNode(_root, value);
  }

  boolean deleteNode(Node node, int value) {
      if (node == null) {
          return false;
      }

      if (node._value == value) {
          if ((node._left == null) && (node._right == null)) {
              // leaf node
              node = null;
              return true;
          } else if ((node._left != null) && (node._right != null)) {
              // node with two children
              node._value = findMinimumAndReturnWithDelete(node._right);
              return true;
          }

          // either left child or right child
          if (node._left != null) {
              parent._left = node._left;
              node = null;
              return true;
          }

          if (node._right != null) {
              parent._right = node._right;
              node = null;
              return true;
          }
      }

      parent = node;
      if (node._value > value) {
          return deleteNode(node._left, value);
      } else {
          return deleteNode(node._right, value);
      }
  }

  int findMinimumAndReturnWithDelete(Node node) {
      if (node._left == null) {
          int v = node._value;
          node = null;
          return v;
      }
      return findMinimumAndReturnWithDelete(node._left);
  }

  public static void main(String[] args) {
    BSTree bst = new BSTree();
    bst.addNode(2);
    bst.addNode(1);
    bst.addNode(3);
    bst.addNode(0);
    //System.out.println("value for root.left:" + bst._root._left._value);
    //System.out.println("value for root.right:" + bst._root._right._value);
 //   bst.deleteNode(3);
 //   bst.deleteNode(0);
    System.out.println("value for root:" + bst._root._value);
    System.out.println("value for root.left:" + bst._root._left._value);
    System.out.println("value for root.right:" + bst._root._right._value);
  }
}
