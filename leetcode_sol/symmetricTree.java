/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
      if(root==null) return true; 
      TreeNode left=root.left; 
      TreeNode right=root.right; 
      return checkSymmetric( left,right); 
    }
    boolean checkSymmetric(TreeNode left, TreeNode right)
    {
        if(left==null && right==null) return true; 
        if(left==null||right==null) return false; 
        if(left.val!=right.val) return false; 
        if(!checkSymmetric(left.left, right.right)) return false; 
        if(!checkSymmetric(left.right, right.left)) return false; 
        return true;       
    }
    
}
