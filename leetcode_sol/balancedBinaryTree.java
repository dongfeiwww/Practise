/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new int[1]);
    }
    
    public boolean isBalanced(TreeNode root, int[] height) {
        if (root == null) {
            height[0] = 0;
            return true;
        }
        int[] leftHeight = new int[1];
        int[] rightHeight = new int[1];
        boolean isBalanced = false;
        if (isBalanced(root.left, leftHeight) && isBalanced(root.right, rightHeight)) {
            if (Math.abs(leftHeight[0] - rightHeight[0]) <= 1) {
                isBalanced = true;
            }
        }
        height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;
        return isBalanced;        
    }
}
