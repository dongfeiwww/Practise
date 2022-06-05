/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class Solution {
  public void connect(TreeLinkNode root) {
    if(root==null) return; 
    if(root.left!=null)
    {
      root.left.next=root.right;
    }
    if(root.right!=null)
    {
      root.right.next=(root.next!=null? root.next.left: null);
    }

    connect(root.left); 
    connect(root.right);
  }
}

// class Solution:
//     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
//         if not root:
//             return root
        
//         # Initialize a queue data structure which contains
//         # just the root of the tree
//         Q = collections.deque([root])
        
//         # Outer while loop which iterates over 
//         # each level
//         while Q:
            
//             # Note the size of the queue
//             size = len(Q)
            
//             # Iterate over all the nodes on the current level
//             for i in range(size):
                
//                 # Pop a node from the front of the queue
//                 node = Q.popleft()
                
//                 # This check is important. We don't want to
//                 # establish any wrong connections. The queue will
//                 # contain nodes from 2 levels at most at any
//                 # point in time. This check ensures we only 
//                 # don't establish next pointers beyond the end
//                 # of a level
//                 if i < size - 1:
//                     node.next = Q[0]
                
//                 # Add the children, if any, to the back of
//                 # the queue
//                 if node.left:
//                     Q.append(node.left)
//                 if node.right:
//                     Q.append(node.right)
        
//         # Since the tree has now been modified, return the root node
//         return root