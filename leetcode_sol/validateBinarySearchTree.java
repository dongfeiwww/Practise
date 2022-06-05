/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true; 
        return 
        checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    boolean checkBST(TreeNode root, int max,  int min)
    {
        if (root==null) 
            return true; 
        if(root.val>=max || root.val<=min) 
            return false; 
        if(!checkBST(root.left, root.val, min)) 
            return false; 
        if(!checkBST(root.right, max, root.val)) 
            return false; 
        return true; 
    }
}
