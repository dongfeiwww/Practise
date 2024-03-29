/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return false; 
        int expect=sum-root.val; 
        if(expect==0 && root.left==null && root.right==null) return true; 
        boolean left=hasPathSum(root.left, expect);
        boolean right=hasPathSum(root.right, expect);
        return left || right; 
    }
}
